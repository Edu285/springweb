package controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan(basePackages= {"controller"})// anotacion para que puede mostarar las jsp del controller
@EnableWebMvc
@Configuration
public class MvcConfig {
	@Bean // cuando se inicia Spring llamara a estos metodos y los guardara para usarlos
	public InternalResourceViewResolver resolver() {
		var resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
