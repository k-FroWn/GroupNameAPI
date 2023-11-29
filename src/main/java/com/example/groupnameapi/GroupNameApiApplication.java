package com.example.groupnameapi;

import com.example.groupnameapi.controller.DbInteraction.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.Date;

@SpringBootApplication
public class GroupNameApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupNameApiApplication.class, args);

		//to run the tests
		//runDelete();
		//runCreate();
		//runUpdate();
		//runSelect();


	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8080").allowedMethods("*");
			}
		};
	}


	//These 4 are for testing and they all work
	public static void runCreate(){
		DB_C_Res.createC_Res(1,1234,true, new Date(2022,12,1), new Date(2022,10,1));
		DBCustomer.createCustomer(1,1,"customer","ustomer","Email",1234,15,true );
		DBFlight.createFlight(1,1234,"Texas","Cali",new Date(2022,12,5),new Date(2022,12,6),"A300",5,25,50);
		DBFlightStatus.createFlightStatus(1,1234,new Date(1,1,1),"Working");
		DBPassengerDetails.createPassengerDetails(1,"email",true,5,1);
		DBRes.createReservation(1,1234,new Date(1,1,1),"jack res","email","active",1,new Date(2,2,2), true,50,4321);
		DBRole.createRole(1,"Admin");
	}
	public static void runUpdate(){
		DB_C_Res.updateC_Res(28008,false, new Date(1111,1,31), new Date(1231,1,28),1);
		DBCustomer.updateUser(1909,"I am the","remotsuc","limae",43210987,1500,false,1 );
		DBFlight.updateFlight(1234,"mars","earth",new Date(2001,11,11),new Date(2022,12,6),"B52 bomber",500,9000,1,1);
		DBFlightStatus.updateFlightStatus(4321,new Date(100,100,100),"not Working well",1);
		DBPassengerDetails.updatePassengerDetails("liame",false,5000,11010,1);
		DBRes.updateReservation(1234,new Date(100,100,100),"res","liame","not",4,new Date(20,20,20), false,1,5678,1);
		DBRole.updateRole("customer",1);
	}
	public static void runDelete(){
		DB_C_Res.deleteC_Res(1);
		DBCustomer.deleteUser(1);
		DBFlight.deleteFlight(1);
		DBFlightStatus.deleteFlightStatus(1);
		DBPassengerDetails.deletePassengerDetails(1);
		DBRes.deleteReservation(1);
		DBRole.deleteRole(1);
	}
	public static void runSelect(){
		DB_C_Res.selectC_Res();
		DBCustomer.selectUser();
		DBFlight.selectFlight();
		DBFlightStatus.selectFlightStatus();
		DBPassengerDetails.selectPassengerDetails();
		DBRes.selectReservation();
		DBRole.selectRole();
	}

}
