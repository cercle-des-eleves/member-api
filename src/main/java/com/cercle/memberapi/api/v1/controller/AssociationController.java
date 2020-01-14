package com.cercle.memberapi.api.v1.controller;

import com.cercle.memberapi.api.v1.model.AssociationDTO;
import com.cercle.memberapi.api.v1.model.AssociationDetailedDTO;
import com.cercle.memberapi.api.v1.model.MemberDTO;
import com.cercle.memberapi.business.domain.Association;
import com.cercle.memberapi.business.service.AssociationService;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<List<AssociationDetailedDTO>> getAllAssociations(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                                           @RequestParam(defaultValue = "id") String sortBy) {
        List<AssociationDetailedDTO> associations = associationService.getAllAssociations(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(associations, HttpStatus.OK);
    }

    /**
     * Create a new association
     *
     * @param association
     * @return
     */
    @PostMapping
    public ResponseEntity<AssociationDTO> saveAssociation(@RequestBody Association association) {
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
    public ResponseEntity<AssociationDetailedDTO> getAssociationById(@PathVariable String associationId) {
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
    public ResponseEntity<AssociationDTO> updateAssociationById(@PathVariable String associationId,
                                                                @RequestBody Association association) {
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
    public ResponseEntity<List<MemberDTO>> getMembersByAssociation(@PathVariable String associationId,
                                                                   @RequestParam(defaultValue = "0") Integer pageNo,
                                                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                                                   @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(associationService.getAssociationMembers(associationId, pageNo, pageSize, sortBy),
                HttpStatus.OK);
    }

//    /**
//     * Retrieve organizations of association
//     *
//     * @param associationId
//     * @return a list of Organization
//     */
//    @GetMapping("{associationId}/organizations")
//    public ResponseEntity<List<OrganizationDTO>> getOrganizationsByAssociation(@PathVariable String associationId) {
//        return new ResponseEntity<>(associationService.getAssociationOrganizations(associationId), HttpStatus.OK);
//    }

    /**
     * Add a member to association
     *
     * @param associationId
     * @param memberId
     * @return
     */
    @PostMapping("{associationId}/members/{memberId}")
    public ResponseEntity<AssociationDTO> addMemberToAssociation(@PathVariable String associationId,
                                                                 @PathVariable String memberId) {
        AssociationDTO association = associationService.addAssociationMember(associationId, memberId);
        return new ResponseEntity<>(association, HttpStatus.OK);
    }

    /**
     * Remove a member from association
     *
     * @param associationId
     * @param memberId
     * @return
     */
    @DeleteMapping("{associationId}/members/{memberId}")
    public ResponseEntity<AssociationDTO> removeMemberFromAssociation(@PathVariable String associationId,
                                                                      @PathVariable String memberId) {
        AssociationDTO association = associationService.removeAssociationMember(associationId, memberId);
        return new ResponseEntity<>(association, HttpStatus.OK);
    }

//    /**
//     * Add a organization to association
//     *
//     * @param associationId
//     * @param organizationId
//     * @return the saved entity
//     */
//    @PostMapping("{associationId}/organizations/{organizationId}")
//    public ResponseEntity<AssociationDTO> addOrganizationToAssociation(@PathVariable String associationId,
//                                                                       @PathVariable String organizationId) {
//        AssociationDTO association = associationService.addAssociationOrganization(associationId, organizationId);
//        return new ResponseEntity<>(association, HttpStatus.OK);
//    }
//
//    /**
//     * Remove a organization from association
//     *
//     * @param associationId
//     * @param organizationId
//     * @return the saved entity
//     */
//    @DeleteMapping("{associationId}/organizations/{organizationId}")
//    public ResponseEntity<AssociationDTO> removeOrganizationFromAssociation(@PathVariable String associationId,
//                                                                            @PathVariable String organizationId) {
//        AssociationDTO association = associationService.removeAssociationOrganization(associationId, organizationId);
//        return new ResponseEntity<>(association, HttpStatus.OK);
//    }
}
