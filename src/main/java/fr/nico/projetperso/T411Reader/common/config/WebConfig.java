package fr.nico.projetperso.T411Reader.common.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

import fr.nico.projetperso.T411Reader.common.model.ServiceRest;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	RequestMappingHandlerMapping handlerMapping;
	
    @Bean
    public ScriptTemplateConfigurer configurer() {
        ScriptTemplateConfigurer configurer = new ScriptTemplateConfigurer();
        //1. Nashorn jdk8 script engine.
        configurer.setEngineName("nashorn");
        //2. Add mustache.min.js and custom render.js to Nashorn
        configurer.setScripts("/META-INF/resources/scripts/polyfill.js",
        			"/META-INF/resources/scripts/ejs.min.js",
        			"/META-INF/resources/scripts/render.js",
        			"/resources/scripts/components/hello.js");
        //3. Ask Nashorn to run this function "render()"
        configurer.setRenderFunction("renderServer");
        configurer.setSharedEngine(false);
        return configurer;
    }
    
    

    /**
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        ScriptTemplateViewResolver viewResolver = new ScriptTemplateViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html"); 
        return viewResolver;
    }

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//Pour swagger
		registry.addResourceHandler("swagger-ui.html")
	      .addResourceLocations("classpath:/META-INF/resources/");
	    registry.addResourceHandler("/webjars/**")
	      .addResourceLocations("classpath:/META-INF/resources/webjars/");
	    
	    //Pour mes tests en local
    	registry
        .addResourceHandler("/resources/**")
        .addResourceLocations("/resources/")
        .setCachePeriod(3600)
        .resourceChain(true)
        .addResolver(new PathResourceResolver());
	}
    
    @Bean
    public List services(){
    	List<ServiceRest> services = new ArrayList<ServiceRest>();
		for ( RequestMappingInfo key : handlerMapping.getHandlerMethods().keySet() ){
			if(!"DO_NOT_SHOW".equals(key.getName()) && !key.getPatternsCondition().getPatterns().contains("/error")){
	        	ServiceRest sr = new ServiceRest();
	        	sr.setName(key.getPatternsCondition().getPatterns().toString());
	        	sr.setUrl(key.getPatternsCondition().getPatterns().toString());
	        	sr.setMethod(key.getMethodsCondition().toString());
	        	services.add(sr);
			}
        }
		return services;
    }
    
    
}