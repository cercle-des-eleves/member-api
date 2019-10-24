package com.cercle.memberapi.api.v1.utils;

import com.cercle.memberapi.business.domain.Association;
import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.domain.Organization;
import com.cercle.memberapi.business.service.MemberService;
import com.cercle.memberapi.persistence.repository.AssociationRepository;
import com.cercle.memberapi.persistence.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Array;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(AssociationRepository associationRepository, MemberRepository memberRepository) {
        return args -> {
            Member member1 = memberRepository.save(new Member(null, "Chenavas", "Jessy", "jessy.chenavas@mines-ales.org", ZonedDateTime.now(), "INFRES"));
            Member member2 = memberRepository.save(new Member(null, "Chenavas2", "Jessy2", "jessy.chenavas@mines-ales.org", ZonedDateTime.now(), "INFRES"));
            List<Member> members = new ArrayList<>();
            members.add(member1);
            members.add(member2);
            Association association = associationRepository.save(new Association(null,"Asso1", true, ZonedDateTime.now(),
                null, new ArrayList<Member>(),  new ArrayList<Organization>(), "SIRETTEST"));

            association.setMembers(members);
            associationRepository.save(association);

            log.info("Preloading " + associationRepository.save(new Association(null,"Asso2", true, ZonedDateTime.now(),
                    null, new ArrayList<Member>(),  new ArrayList<Organization>(), "SIRETTEST")));
            log.info("Preloading " + associationRepository.save(new Association(null,"Asso3", true, ZonedDateTime.now(),
                    null, new ArrayList<Member>(),  new ArrayList<Organization>(), "SIRETTEST")));
            log.info("Preloading " + associationRepository.save(new Association(null,"Asso4", true, ZonedDateTime.now(),
                    null, new ArrayList<Member>(),  new ArrayList<Organization>(), "SIRETTEST")));

        };
    }
}

