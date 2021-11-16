package org.sid.compteservice.service;

import org.sid.compteservice.entities.Compte;
import org.sid.compteservice.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {
    @Autowired
    private CompteRepository compteR;

    @Override
    public void virement(Long codeSource, Long codeDestination, double montant) {
        Compte c1= compteR.getById(codeSource);
        Compte c2= compteR.getById(codeDestination);
        c1.setSolde(c1.getSolde()-montant);
        c2.setSolde(c2.getSolde()+montant);
        compteR.save(c1);
        compteR.save(c2);
    }
}
