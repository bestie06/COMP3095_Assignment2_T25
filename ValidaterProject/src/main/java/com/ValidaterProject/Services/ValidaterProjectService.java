/*******************************************************************************************************************
 * Project: Comp-3095 Assignment 2
 * Assignment: 2
 * Author(s): Zac Shaw, Yazan Siyam, Joushua Burnett Rooney, Fatih Kucukgokmen
 * Student Number: 101074878, 101210557 , 101212739, 101168654
 * Date: 11/08/2020
 * Description: Validator Service implementation
 * ****************************************************************************************************************/
package com.ValidaterProject.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ValidaterProject.Repo.ValidaterProjectRepo;
import com.ValidaterProject.beans.User;

/**
 * @author
 *
 */
@Service
public class ValidaterProjectService implements ValidaterProjectIntf {

	@Autowired
	ValidaterProjectRepo validaterProjectRepo;

	@Override
	public User SavedUser(User user) {
		validaterProjectRepo.save(user);
		return getsavedatabyid(user);
	}



	private User getsavedatabyid(User user) { // return
		return validaterProjectRepo.findById(user.getId()); // TODO Auto-generated

	}

	@Override
	public User alreadyregistered(String email) {


		return validaterProjectRepo.findByEmail(email);
	}
	
	
	
	@Override
	public User loginValid(User user) {
				
		User us=validaterProjectRepo.findByEmail(user.getEmail());


		User usr=new User();
		if(us!=null)
		{
	     usr=validaterProjectRepo.findByEmailAndPasswordAndRole(user.getEmail(), user.getPassword(), us.getRole());
				
		}
		
		return usr;
	}



	
	
	
}
