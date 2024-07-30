package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = {"service","controller"})
public class Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//---navegaciones estaticas del controller---///
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/toBuscar").setViewName("buscar");
		registry.addViewController("/toNuevo").setViewName("nuevo");
		registry.addViewController("/").setViewName("menu");
		registry.addViewController("/toInicio").setViewName("menu");
		registry.addViewController("/toEliminar").setViewName("eliminar");
				
		WebMvcConfigurer.super.addViewControllers(registry);
	}
}
