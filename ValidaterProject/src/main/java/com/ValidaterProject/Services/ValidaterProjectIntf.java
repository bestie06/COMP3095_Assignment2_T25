/*******************************************************************************************************************
 * Project: Comp-3095 Assignment 2
 * Assignment: 2
 * Author(s): Zac Shaw, Yazan Siyam, Joushua Burnett Rooney, Fatih Kucukgokmen
 * Student Number: 101074878, 101210557 , 101212739, 101168654
 * Date: 11/08/2020
 * Description: Validatory Service
 * ****************************************************************************************************************/

package com.ValidaterProject.Services;

import com.ValidaterProject.beans.User;

public interface ValidaterProjectIntf {

	public User SavedUser(User user);
 	public User alreadyregistered(String email);
 	public User loginValid(User user);
}
