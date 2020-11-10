/*******************************************************************************************************************
 * Project: Comp-3095 Assignment 2
 * Assignment: 2
 * Author(s): Zac Shaw, Yazan Siyam, Joushua Burnett Rooney, Fatih Kucukgokmen
 * Student Number: 101074878, 101210557 , 101212739, 101168654
 * Date: 11/08/2020
 * Description: repository functions
 * ****************************************************************************************************************/

package com.ValidaterProject.Repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ValidaterProject.beans.User;


public interface ValidaterProjectRepo extends JpaRepository<User, Long>{

	public User findByEmailAndPasswordAndRole(String email,String password,String role);
	public User findByEmail(String email);
	public User findById(int id);
}
