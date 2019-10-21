package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.api.v1.AssociationMapper;
import com.cercle.memberapi.api.v1.MemberMapper;
import com.cercle.memberapi.api.v1.OrganizationMapper;
import com.cercle.memberapi.api.v1.model.AssociationDTO;
import com.cercle.memberapi.api.v1.model.MemberDTO;
import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.business.domain.Association;
import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.domain.Organization;
import com.cercle.memberapi.business.exception.ResourceNotFoundException;
import com.cercle.memberapi.business.service.AssociationService;
import com.cercle.memberapi.persistence.repository.AssociationRepository;
import com.cercle.memberapi.persistence.repository.MemberRepository;
import com.cercle.memberapi.persistence.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssociationServiceImpl implements AssociationService {

    private AssociationRepository associationRepository;
    private OrganizationRepository organizationRepository;
    private MemberRepository memberRepository;
    private AssociationMapper associationMapper;
    private OrganizationMapper organizationMapper;

    public AssociationServiceImpl(AssociationRepository associationRepository,
                                  OrganizationRepository organizationRepository, MemberRepository memberRepository,
                                  AssociationMapper associationMapper, OrganizationMapper organizationMapper) {
        this.associationRepository = associationRepository;
        this.organizationRepository = organizationRepository;
        this.memberRepository = memberRepository;
        this.associationMapper = associationMapper;
        this.organizationMapper = organizationMapper;
    }

    /**
     * Retrieve all associations
     *
     * @return List<AssociationDTO>
     */
    @Override
    public List<AssociationDTO> getAllAssociations() {
        List<Association> result = associationRepository.findAll();

        return result.stream().map(associationMapper::toAssociationDTO).collect(Collectors.toList());
    }

    @Override
    public AssociationDTO saveAssociation(Association association) {
        Association result = associationRepository.save(association);

        return associationMapper.toAssociationDTO(result);
    }

    @Override
    public AssociationDTO getAssociationById(String id) {
        return associationRepository.findById(id)
            .map(association -> associationMapper.toAssociationDTO(association))
            .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public AssociationDTO updateAssociation(Association association) {
        Association result = associationRepository.save(association);

        return associationMapper.toAssociationDTO(result);
    }

    @Override
    public void deleteAssociation(String id) {
        try {
            associationRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public List<MemberDTO> getAssociationMembers(String id) {
        Optional<Association> association = associationRepository.findById(id);
        if (association.isPresent()) {
            List<Member> members = association.get().getMembers();
            return members.stream().map(MemberMapper::toMemberDTO).collect(Collectors.toList());
        } else {
            throw new ResourceNotFoundException();
        }

    }

    @Override
    public List<OrganizationDTO> getAssociationOrganizations(String id) {
        Optional<Association> association = associationRepository.findById(id);

        return association.map(
            value -> value.getOrganizations().stream().map(organizationMapper::toGroupDTO).collect(Collectors.toList()))
            .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public AssociationDTO addAssociationOrganization(String associationId, String organizationId) {
        Optional<Association> association = associationRepository.findById(associationId);
        Optional<Organization> organization = organizationRepository.findById(organizationId);

        if (association.isPresent() && organization.isPresent()) {
            Association asso = association.get();
            asso.getOrganizations().add(organization.get());
            asso = associationRepository.save(asso);
            return associationMapper.toAssociationDTO(asso);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public AssociationDTO removeAssociationOrganization(String associationId, String organizationId) {
        Optional<Association> association = associationRepository.findById(associationId);
        Optional<Organization> organization = organizationRepository.findById(organizationId);

        if (association.isPresent() && organization.isPresent()) {
            Association asso = association.get();
            asso.getOrganizations().remove(organization.get());
            asso = associationRepository.save(asso);
            return associationMapper.toAssociationDTO(asso);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public AssociationDTO addAssociationMember(String associationId, String memberId) {
        Optional<Association> association = associationRepository.findById(associationId);
        Optional<Member> member = memberRepository.findById(memberId);

        if (association.isPresent() && member.isPresent()) {
            Association asso = association.get();
            asso.getMembers().remove(member.get());
            asso = associationRepository.save(asso);
            return associationMapper.toAssociationDTO(asso);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public AssociationDTO removeAssociationMember(String associationId, String memberId) {
        Optional<Association> association = associationRepository.findById(associationId);
        Optional<Member> member = memberRepository.findById(memberId);

        if (association.isPresent() && member.isPresent()) {
            Association asso = association.get();
            asso.getMembers().remove(member.get());
            asso = associationRepository.save(asso);
            return associationMapper.toAssociationDTO(asso);
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
