package com.cercle.memberapi.api.v1.controller;

import com.cercle.memberapi.api.v1.model.AssociationDTO;
import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.api.v1.model.OrganizationsDTO;
import com.cercle.memberapi.business.domain.Association;
import com.cercle.memberapi.business.service.AssociationService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@NoArgsConstructor
@Controller
@RequestMapping(path = "/associations")
public class AssociationController {

    private AssociationService associationService;

    @GetMapping
    public ResponseEntity<List<AssociationDTO>> getAllAssociations() {
        List<AssociationDTO> associations = associationService.getAllAssociations();
        return new ResponseEntity<>(associations, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AssociationDTO> saveAssociation(Association association) {
        AssociationDTO result = associationService.saveAssociation(association);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
