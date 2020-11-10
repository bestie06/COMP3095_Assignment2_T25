/*******************************************************************************************************************
 * Project: Comp-3095 Assignment 2
 * Assignment: 2
 * Author(s): Zac Shaw, Yazan Siyam, Joushua Burnett Rooney, Fatih Kucukgokmen
 * Student Number: 101074878, 101210557 , 101212739, 101168654
 * Date: 11/08/2020
 * Description: Main File
 * ****************************************************************************************************************/

package com.ValidaterProject;

import com.ValidaterProject.beans.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class ValidaterProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidaterProjectApplication.class, args);
	}

}
