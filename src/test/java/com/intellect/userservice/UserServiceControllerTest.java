/**
 * 
 */
package com.intellect.userservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.intellect.controller.UserController;
import com.intellect.dto.Result;
import com.intellect.enums.ErrorCode;
import com.intellect.user.service.UserService;
import com.intellect.user.service.impl.UserServiceImpl;
import com.intellect.util.ValidateRequest;

/**
 * @author admin
 *
 */
public class UserServiceControllerTest {

	UserController userContrller=new UserController();
	
	
	@InjectMocks
	private UserService userService=new UserServiceImpl();
	
	@Mock
	private ValidateRequest validateRequest;
	
	
	 private MockMvc mockMvc;
	
	
	@Before
	public void init(){
	
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userContrller).build();
	}
	
	@Test
	public void testCreateUserWithBadRequest() throws Exception{
		
		 this.mockMvc.perform(post("/api/user/create")
		            .param("email", "mvcemail@test.com")
		            .param("fname", "mvcfirst")
		            .param("lname", "mvclastname").param("pinCode","414001").param("birthdate", "1510998908464").param("isActive", "true"))
		            .andExpect(status().isBadRequest());
		
	}

	//@Test
	public void testDeleteUser() throws Exception{
		
        Result  result=new Result(ErrorCode.ERROR)	 ;
		Mockito.when(userService.deleteUser(String.valueOf(System.currentTimeMillis()))).thenReturn(result);
		 this.mockMvc.perform(get("/api/user/delete/{userid}",String.valueOf(System.currentTimeMillis())))
		            .andExpect(status().isOk());
		
	}

	
	
}
