package com.mthree;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mthree.models.User;
import com.mthree.services.EventService;
import com.mthree.services.UserService;

@SpringBootTest
class SpringWebAndDataJpaApplicationTests {
	
	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		
		User user=null;
		
		Optional<User> u=userService.getUserById(2);
		if(u.isPresent()) {
			user=u.get();
			
			assertNotNull(user);
		}
	}

}
