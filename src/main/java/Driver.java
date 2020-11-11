

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sdnetwork.model.Post;
import com.sdnetwork.model.User;
import com.sdnetwork.repo.UserDao;
import com.sdnetwork.service.PostService;


public class Driver {

	public static void main(String[] args) {

//		System.out.println(u);
//		System.out.println(ud.findAll());
//		System.out.println(ud.findById(1));
//		u.setLastName("iaf");
//		System.out.println(ud.update(u));
//		System.out.println(ud.delete(u.getUserId()));
//
//		((ConfigurableApplicationContext)ac).close();
//		System.out.println(ud.findByUsername("notreal"));
		ApplicationContext ac =
			    new FileSystemXmlApplicationContext(
			        "src/main/webapp/WEB-INF/applicationContext.xml"
			    );
		
		PostService ps = ac.getBean(PostService.class);
		UserDao ud = ac.getBean(UserDao.class);
		User u = ud.findById(1);
//		Post p = new Post(u,"a",false,"a");
//		ps.createNew(p);
		((ConfigurableApplicationContext)ac).close();
		


	}

}
