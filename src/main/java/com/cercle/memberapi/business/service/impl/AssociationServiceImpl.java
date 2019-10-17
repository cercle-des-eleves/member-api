package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.api.v1.AssociationMapper;
import com.cercle.memberapi.api.v1.OrganizationMapper;
import com.cercle.memberapi.api.v1.model.AssociationDTO;
import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.business.domain.Association;
import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.domain.Organization;
import com.cercle.memberapi.business.service.AssociationService;
import com.cercle.memberapi.persistence.repository.AssociationRepository;
import org.springframework.http.HttpStatus;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AssociationServiceImpl implements AssociationService {

    private AssociationRepository associationRepository;
    private AssociationMapper associationMapper;
    private OrganizationMapper organizationMapper;

    @Override
    public List<AssociationDTO> getAllAssociations() {
        List<Association> result = associationRepository.findAll();

        return result.stream()
                .map(associationMapper::toAssociationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AssociationDTO saveAssociation(Association association) {
        Association result = associationRepository.save(association);

        return associationMapper.toAssociationDTO(result);
    }

    @Override
    public AssociationDTO getAssociationById(String id) {
        Optional<Association> result = associationRepository.findById(id);
        return result.map(association -> associationMapper.toAssociationDTO(association)).orElse(null);
    }

    @Override
    public AssociationDTO updateAssociation(Association association) {
        Association result = associationRepository.save(association);

        return associationMapper.toAssociationDTO(result);
    }

    @Override
    public HttpStatus deleteAssociation(String id) {
        try {
            associationRepository.deleteById(id);
        } catch (EntityNotFoundException e) { // just showing what I want to do
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }

    @Override
    public List<Member> getAssociationMembers(String id) {
        Optional<Association> association = associationRepository.findById(id);

        return association.map(Organization::getMembers).orElse(null);
    }

    @Override
    public List<OrganizationDTO> getAssociationOrganizations(String id) {
        Optional<Association> association = associationRepository.findById(id);

        if (association.isPresent()) {
            return association.get().getOrganizations().stream().map(organizationMapper::toGroupDTO).collect(Collectors.toList());
        } else {
            return new ArrayList<OrganizationDTO>();
        }
    }
}
