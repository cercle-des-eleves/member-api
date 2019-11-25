package com.cercle.memberapi.api.v1.security;

import com.cercle.memberapi.authentication.model.User;
import org.jasig.cas.client.validation.Cas30ServiceTicketValidator;
import org.jasig.cas.client.validation.TicketValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsServiceConfigurer;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;

public class CasConfig {
    //8443

    @Bean
    public ServiceProperties serviceProperties() {
        ServiceProperties serviceProperties = new ServiceProperties();
        serviceProperties.setService("http://localhost:8000/login/cas");
        serviceProperties.setSendRenew(false);
        return serviceProperties;
    }

    @Bean
    @Primary
    public AuthenticationEntryPoint authenticationEntryPoint(
            ServiceProperties sP) {

        CasAuthenticationEntryPoint entryPoint
                = new CasAuthenticationEntryPoint();
        entryPoint.setLoginUrl("https://localhost:6443/cas/login");
        entryPoint.setServiceProperties(sP);
        return entryPoint;
    }

    @Bean
    public TicketValidator ticketValidator() {
        return new Cas30ServiceTicketValidator(
                "https://localhost:6443/cas");
    }

    @Bean
    public CasAuthenticationProvider casAuthenticationProvider() {

        CasAuthenticationProvider provider = new CasAuthenticationProvider();
        provider.setServiceProperties(serviceProperties());
        provider.setTicketValidator(ticketValidator());
//        provider.setUserDetailsService(new UserDetailsServiceConfigurer<>());
        provider.setKey("");
        return provider;
    }
}
