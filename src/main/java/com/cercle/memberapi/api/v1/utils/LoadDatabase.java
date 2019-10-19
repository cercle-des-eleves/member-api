package com.cercle.memberapi.api.v1.utils;

import com.cercle.memberapi.business.domain.Association;
import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.domain.Organization;
import com.cercle.memberapi.business.service.MemberService;
import com.cercle.memberapi.persistence.repository.AssociationRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;
import java.util.ArrayList;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(AssociationRepository associationRepository) {
        return args -> {
            log.info("Preloading " + associationRepository.save(new Association(null,"Asso1", true, ZonedDateTime.now(),
                    null, new ArrayList<Member>(),  new ArrayList<Organization>(), "SIRETTEST")));
            log.info("Preloading " + associationRepository.save(new Association(null,"Asso2", true, ZonedDateTime.now(),
                    null, new ArrayList<Member>(),  new ArrayList<Organization>(), "SIRETTEST")));
            log.info("Preloading " + associationRepository.save(new Association(null,"Asso3", true, ZonedDateTime.now(),
                    null, new ArrayList<Member>(),  new ArrayList<Organization>(), "SIRETTEST")));
            log.info("Preloading " + associationRepository.save(new Association(null,"Asso4", true, ZonedDateTime.now(),
                    null, new ArrayList<Member>(),  new ArrayList<Organization>(), "SIRETTEST")));

        };
    }
}

