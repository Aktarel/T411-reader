package fr.nico.projetperso.T411Reader.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateConfigurer;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

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

    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry
        .addResourceHandler("/resources/**")
        .addResourceLocations("/resources/")
        .setCachePeriod(3600)
        .resourceChain(true)
        .addResolver(new PathResourceResolver());
	}

}