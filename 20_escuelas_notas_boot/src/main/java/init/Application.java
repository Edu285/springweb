package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableJpaRepositories(basePackages={"dao"})
@EntityScan(basePackages= {"entities"}) //para decirle donde estan las entidades
@SpringBootApplication(scanBasePackages = {"service","controller","utilidades"})
public class Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("inicio");
		registry.addViewController("/toInicio").setViewName("inicio");
		registry.addViewController("/toALta").setViewName("alta");
					
		WebMvcConfigurer.super.addViewControllers(registry);
	}	
}
