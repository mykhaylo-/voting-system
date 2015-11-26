package com.michael.votingsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.bind.support.AuthenticationPrincipalArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {


    // FIXME: https://jira.spring.io/browse/SEC-2942
    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new AuthenticationPrincipalArgumentResolver());
    }
}
