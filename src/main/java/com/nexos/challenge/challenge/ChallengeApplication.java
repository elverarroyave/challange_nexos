package com.nexos.challenge.challenge;

import com.nexos.challenge.challenge.role.model.Role;
import com.nexos.challenge.challenge.role.service.RoleGateway;
import com.nexos.challenge.challenge.user.io.repository.UserRepository;
import com.nexos.challenge.challenge.user.model.User;
import com.nexos.challenge.challenge.user.service.UserGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(ChallengeApplication.class, args);

		//Beans
		UserGateway userRepository = configurableApplicationContext.getBean(UserGateway.class);
		RoleGateway roleGateway = configurableApplicationContext.getBean(RoleGateway.class);

		/*
		//Creamos los roles de la aplicacion
		Role salesAdvisor = new Role(1L, "Asesor de ventas", "Los asesores de ventas facilitan las transacciones de ventas al asesorar a los clientes sobre los productos adecuados que mejor satisfacen sus necesidades y fomentan las compras.");
		Role admin = new Role(2L, "Administrador", " persona cuyo trabajo implica ayudar a organizar y supervisar la forma en que funciona una organización o institución ");
		Role support = new Role(3L, "Soporte", "El soporte técnico es un rango de servicios por medio del cual se proporciona asistencia a los usuarios al tener algún problema al utilizar un producto o servicio, ya sea este el hardware o software de una computadora de un servidor de Internet, periféricos, artículos electrónicos, maquinaria, o cualquier otro equipo o dispositivo.");

		//Persistimos los roles
		roleGateway.create(salesAdvisor);
		roleGateway.create(admin);
		roleGateway.create(support);

		//Creamos los usuarios de la aplciacion
		User pepe = new User("Pepe Flores",32,	LocalDate.now());
		User sara = new User("Sara Jaramillo",24,LocalDate.now());
		User juan = new User("Juan Torres",28,	LocalDate.now());

		//Añadimos los roles a los usuarios, con la posibilidad de que un usuario posea más roles.
		pepe.addRole(salesAdvisor);
		sara.addRole(admin);
		juan.addRole(support);

		//Persistimos los usuario con sus respectivos roles
		userRepository.create(pepe);
		userRepository.create(sara);
		userRepository.create(juan);
		*/


	}

}
