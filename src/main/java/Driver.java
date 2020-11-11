

import java.util.LinkedList;
import java.util.List;

import com.sdnetwork.model.User;


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
	//	ApplicationContext ac =
	//		    new FileSystemXmlApplicationContext(
	//		        "src/main/webapp/WEB-INF/applicationContext.xml"
	//		    );
		
	//	PostService ps = ac.getBean(PostService.class);
	//	UserDao ud = ac.getBean(UserDao.class);
		UserDaoTest ud= new UserDaoTest();
		List<User> li = new LinkedList<User>();
		li = ud.findAll();
		System.out.println(li.get(0).getEmail());
//		User u = ud.findById(1);
//		Post p = new Post(u,"a",false,"a");
//		ps.createNew(p);
//		((ConfigurableApplicationContext)ac).close();
		


	}

}
