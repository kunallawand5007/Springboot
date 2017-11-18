/**
 * 
 */
package com.intellect.user.service;

import java.util.List;

import com.intellect.dto.Result;
import com.intellect.model.UserModel;

/**
 * @author admin
 *
 */
public interface UserService {

	public String createUser(UserModel userModel);
	
	public Result deleteUser(String userid);
	
	public Result updateUser(UserModel usermodel);
	
	public List<UserModel> userList();
	
}
