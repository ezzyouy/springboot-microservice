package org.sid.compteservice.dtos;

import lombok.Data;

@Data
public class VirementRequestDTO {

    private long codeSource;
    private long codeDestination;
    private  double montant;
}
