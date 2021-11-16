package org.sid.compteservice.web;

import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RestController
public class CompteRestController {

    private CompteRepository compteRep;

    public CompteRestController(CompteRepository compteRepository){
        this.compteRep=compteRepository;
    }

    @GetMapping(path="/comptes")
    public List<Compte> listCompte(){
        return compteRep.findAll();
    }

    @GetMapping(path="/comptes/{id}")
    public Compte getCompte(@PathVariable(name = "id") Long id){
        return compteRep.findById(id).get();
    }

    @PostMapping(path = "/comptes")
    public Compte save(@RequestBody Compte c){
        return compteRep.save(c);
    }

    @PutMapping(path = "/comptes/{id}")
    public Compte update(@PathVariable(name = "id") long id, @RequestBody Compte c){
        c.setCode(id);
        return compteRep.save(c);
    }

    @DeleteMapping(path = "/comptes/{id}")
    public void save(@PathVariable(name = "id") long id){
         compteRep.deleteById(id);
    }
}
