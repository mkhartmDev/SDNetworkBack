package com.sdnetwork.repoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sdnetwork.dto.RestUser;
import com.sdnetwork.model.User;
import com.sdnetwork.repo.UserDao;

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@ExtendWith(MockitoExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class UserDaoTest {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-test.xml");
	
	private UserDao ud = ac.getBean(UserDao.class);
	private User user0 = new User(0,"kelsey","kelsey","kelsey","kelsey","kelsey","");
	
	@Test
	void testASave() {
		assertNotNull(ud.save(user0));
		assertNull(ud.save(user0));
		fail("Not yet implemented");
	}

	@Test
	@Transactional
	void testBFindAll() {
		List<RestUser> users = ud.findAll();
		System.out.println(users);
		assertEquals(1, users.size());
	}

	@Test
	void testCFindById() {
		assertNotNull(ud.findById(user0.getUserId()));
		assertNull(ud.findById(2));
		fail("Not yet implemented");
	}

	@Test
	void testDFindByUsername() {
		assertNotNull(ud.findByUsername(user0.getUsername()));
		assertNull(ud.findByUsername("yeslek"));
		fail("Not yet implemented");
	}
	
	@Test
	void testEFindByEmail() {
		fail("Not yet implemented");
	}
	
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}


	@Test
	void testDelete() {
		fail("Not yet implemented");
	}



	@Test
	void testFindBySearch() {
		fail("Not yet implemented");
	}

}
