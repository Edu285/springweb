package service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages= {"service"})	//anotacion para incluir los paquetes
@Configuration	// anotacion para indicarle que es una clase de configuracion
public class ServiceConfig {

}