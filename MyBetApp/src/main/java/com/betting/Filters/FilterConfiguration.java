package com.betting.Filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

public class FilterConfiguration {

    @Autowired
    private CustomFilter customFilter;

    @Bean
    public FilterRegistrationBean<CustomFilter>filterFilterRegistrationBean(){
        FilterRegistrationBean<CustomFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(customFilter);
        filterFilterRegistrationBean.addUrlPatterns("/bet/**");

        return filterFilterRegistrationBean;
    }

}
