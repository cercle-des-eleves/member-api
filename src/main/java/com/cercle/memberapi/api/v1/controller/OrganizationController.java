package com.cercle.memberapi.api.v1.controller;

import com.cercle.memberapi.api.v1.model.AssociationDTO;
import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.business.service.OrganizationService;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@NoArgsConstructor
@Controller
@RequestMapping(path = "/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations() {
        List<OrganizationDTO> organizations = organizationService.getAllOrganizations();
        return new ResponseEntity<List<OrganizationDTO>>(organizations, HttpStatus.OK);
    }

    @GetMapping("{organizationId}")
    public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable String organizationId) {
        return new ResponseEntity<>(organizationService.getOrganizationWithID(organizationId), HttpStatus.OK);
    }
}
