package com.sdnetwork.repoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sdnetwork.model.Post;
import com.sdnetwork.model.User;
import com.sdnetwork.repo.PostDao;
import com.sdnetwork.repo.UserDao;

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@ExtendWith(MockitoExtension.class)
@Transactional
@Rollback(true)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PostDaoTest {

	private static ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-test.xml");
	
	private PostDao pd = ac.getBean(PostDao.class);
	private UserDao ud = ac.getBean(UserDao.class);
	
	private Post post = new Post();
	private User user0 = new User(0,"kelsey","kelsey","kelsey","kelsey","kelsey","");
	{
		this.user0 = ud.save(user0);
		this.post.setPosterId(1);
		this.post.setImagePost(false);
	}
	
	@BeforeClass
	@Order(1)
	public void init() {
	}
	
	@Test
	@Order(2)
	void ASavetest() { 
		this.post = pd.save(post);
		assertNotNull(post);
	}

	@Test
	@Order(3)
	void BFindAlltest() { 
		assertNotNull(pd.findAll());
	}

//	@Test
//	@Order(4)
//	void DUpdatetest() { 
//		post.setPostText("world");
//		assertNotNull(pd.update(post));
//	}

	@Test
	@Order(5)
	void EFindByUserIdtest() { 
		assertNotNull(pd.findByUserId(1));
	}

	@Test
	@Order(6)
	void ZDeletetest() { 
		assertNotNull(pd.delete(1));
	}
}
