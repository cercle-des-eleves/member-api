package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.api.v1.OrganizationMapper;
import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.business.domain.Organization;
import com.cercle.memberapi.business.service.OrganizationService;
import com.cercle.memberapi.persistence.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationMapper organizationMapper;
    private OrganizationRepository organizationRepository;

    public OrganizationServiceImpl(OrganizationMapper organizationMapper, OrganizationRepository organizationRepository) {
        this.organizationMapper = organizationMapper;
        this.organizationRepository = organizationRepository;
    }


    @Override
    public OrganizationDTO getOrganizationWithID(String id) {
        Optional<Organization> result = organizationRepository.findById(id);

        return result.map(group -> organizationMapper.toOrganizationDTO(group)).orElseThrow(() -> new RuntimeException("Organization Not Found"));
    }

    @Override
    public List<OrganizationDTO> getAllOrganizations() {
        List<Organization> result = organizationRepository.findAll();

        return result.stream()
                .map(organizationMapper::toOrganizationDTO)
                .collect(Collectors.toList());
    }
}
