package com.cercle.memberapi.api.v1.controller;

import com.cercle.memberapi.api.v1.model.AssociationDTO;
import com.cercle.memberapi.api.v1.model.MemberDTO;
import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.api.v1.model.OrganizationsDTO;
import com.cercle.memberapi.business.domain.Association;
import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.service.AssociationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/associations")
public class AssociationController {

    private AssociationService associationService;

    /**
     * Retrieve all associations
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<AssociationDTO>> getAllAssociations() {
        List<AssociationDTO> associations = associationService.getAllAssociations();
        return new ResponseEntity<>(associations, HttpStatus.OK);
    }

    /**
     * Create a new association
     *
     * @param association
     * @return
     */
    @PostMapping
    public ResponseEntity<AssociationDTO> saveAssociation(Association association) {
        AssociationDTO result = associationService.saveAssociation(association);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get specific association
     *
     * @param associationId
     * @return
     */
    @GetMapping("{associationId}")
    public ResponseEntity<AssociationDTO> getAssociationById(@PathVariable String associationId) {
        return new ResponseEntity<>(associationService.getAssociationById(associationId), HttpStatus.OK);
    }

    /**
     * Update specific association
     *
     * @param associationId
     * @param association
     * @return
     */
    @PutMapping("{associationId}")
    public ResponseEntity<AssociationDTO> updateAssociationById(@PathVariable String associationId, @RequestBody Association association) {
        System.out.println(association.getActive());
        System.out.println(associationService.getAssociationById(associationId));
        AssociationDTO asso = associationService.updateAssociation(association);

        return new ResponseEntity<>(asso, HttpStatus.OK);
    }

    /**
     * Delete specific association
     *
     * @param associationId
     * @return
     */
    @DeleteMapping("{associationId}")
    public ResponseEntity<AssociationDTO> deleteAssociationById(@PathVariable String associationId) {
        associationService.deleteAssociation(associationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Retrieve members of association
     *
     * @param associationId
     * @return
     */
    @GetMapping("{associationId}/members")
    public ResponseEntity<List<MemberDTO>> getMembersByAssociation(@PathVariable String associationId) {
        return new ResponseEntity<>(associationService.getAssociationMembers(associationId), HttpStatus.OK);
    }

    
}
