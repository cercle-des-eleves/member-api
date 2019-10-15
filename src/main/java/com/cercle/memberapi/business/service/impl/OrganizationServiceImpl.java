package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.api.v1.OrganizationMapper;
import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.business.domain.Organization;
import com.cercle.memberapi.business.service.OrganizationService;
import com.cercle.memberapi.persistence.repository.OrganizationGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationMapper organizationMapper;
    private OrganizationGateway organizationGateway;

    public OrganizationServiceImpl(OrganizationMapper organizationMapper, OrganizationGateway organizationGateway) {
        this.organizationMapper = organizationMapper;
        this.organizationGateway = organizationGateway;
    }


    @Override
    public OrganizationDTO getOrganizationWithID(String id) {
        Optional<Organization> result = organizationGateway.findById(id);

        return result.map(group -> organizationMapper.toGroupDTO(group)).orElseThrow(() -> new RuntimeException("Organization Not Found"));
    }

    @Override
    public List<OrganizationDTO> getAllOrganizations() {
        List<Organization> result = organizationGateway.findAll();

        return result.stream()
                .map(organizationMapper::toGroupDTO)
                .collect(Collectors.toList());
    }
}
