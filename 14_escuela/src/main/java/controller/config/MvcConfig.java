package controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@ComponentScan(basePackages= {"controller"})// anotacion para que puede mostarar las jsp del controller
@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer{
	/*@Bean // cuando se inicia Spring llamara a estos metodos y los guardara para usarlos
	public InternalResourceViewResolver resolver() {
		var resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}*/
	//al utilizar thymeleaf esta parte sera sustituida por la siguiente -desde aqui- y se usara en todas la aplicacione sigual
	
	@Autowired
	private ApplicationContext applicationContext;
	@Bean
	public SpringResourceTemplateResolver templateResolver(){
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(this.applicationContext);
		templateResolver.setPrefix("/");
		templateResolver.setSuffix(".html");
		// HTML es la plantilla por defecto, se indica por claridad.
		templateResolver.setTemplateMode(TemplateMode.HTML);
		return templateResolver;
	}
	@Bean
	public SpringTemplateEngine templateEngine(){ 
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}
	@Bean
	public ThymeleafViewResolver viewResolver(){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		return viewResolver;
	} 
	/////////////////hasta aqui////////////////////
		
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("inicio");
		registry.addViewController("/toInicio").setViewName("inicio");
		registry.addViewController("/toALta").setViewName("alta");
					
		WebMvcConfigurer.super.addViewControllers(registry);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/*").addResourceLocations("/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
}
