package com.sdnetwork.repoTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sdnetwork.dto.RestUser;
import com.sdnetwork.model.User;
import com.sdnetwork.repo.UserDao;

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@ExtendWith(MockitoExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@Rollback(true)
class UserDaoTest {
	
	private static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-test.xml");
	
	private UserDao ud = ac.getBean(UserDao.class);
	private User user0 = new User(0,"kelsey","kelsey","kelsey","kelsey","kelsey","");
	
	@Test
	@Order(1)
	void testASave() {
		this.user0 = ud.save(user0);
		assertNotNull(user0);
		assertNull(ud.save(user0));
	}

	@Test
	@Order(2)
	void testBFindAll() {
		List<RestUser> users = ud.findAll();
		System.out.println(users);
		assertEquals(1, users.size());
	}

	@Test
	@Order(3)
	void testBFindById() {
		assertNotNull(ud.findById(1));
	}

	@Test
	@Order(4)
	void testDFindByUsername() {
		assertNotNull(ud.findByUsername(user0.getUsername()));
		assertNull(ud.findByUsername("yeslek"));
	}
	
	@Test
	@Order(5)
	void testEFindByEmail() {
			User use = ud.findByEmail("kelsey");
			assertNotNull(use);
	}

	@Test
	@Order(6)
	void testFFindBySearch() {
		assertNotNull(ud.findBySearch("kelsey"));
		assertTrue((ud.findBySearch("yeslek")).isEmpty());
	}
	
//	@Test
//	@Order(7)
//	void testJUpdate() {
//		user0.setEmail("yeslek");
//		user0 = ud.update(user0);
//		assertEquals("yeslek", user0.getEmail());
//	}


	@Test
	@Order(8)
	void testADelete() {
		assertNotNull(ud.delete(1));

	}




}
