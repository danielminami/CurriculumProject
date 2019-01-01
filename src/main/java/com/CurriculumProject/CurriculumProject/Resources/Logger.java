package com.CurriculumProject.CurriculumProject.Resources;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.CustomizableTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class Logger {

    @Bean
	public CommonsRequestLoggingFilter logFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
	    filter.setIncludeQueryString(true);
	    filter.setIncludePayload(true);
	    filter.setIncludeClientInfo(true);
	    filter.setMaxPayloadLength(10000);
	    filter.setIncludeHeaders(true);
	    filter.setAfterMessagePrefix("REQUEST DATA : ");
	    return filter;
	}
    
    @Bean
    public CustomizableTraceInterceptor customizableTraceInterceptor() {
        CustomizableTraceInterceptor cti = new CustomizableTraceInterceptor();
        return cti;
    }
    
    @Bean
    public Advisor traceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public * biz.deinum..*.*(..))");
        return new DefaultPointcutAdvisor(pointcut, customizableTraceInterceptor());
    }
}
