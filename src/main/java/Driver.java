

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdnetwork.model.User;
import com.sdnetwork.repo.UserDao;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao ud = ac.getBean(UserDao.class);
		User u = new User("cats", "q", "f", "d", "p", "q");

//		ud.save(u);
//		System.out.println(u);
//		System.out.println(ud.findAll());
//		System.out.println(ud.findById(1));
//		u.setLastName("iaf");
//		System.out.println(ud.update(u));
//		System.out.println(ud.delete(u.getUserId()));
//		
//		((ConfigurableApplicationContext)ac).close();
		System.out.println(ud.findByUsername("notreal"));


	}

}
