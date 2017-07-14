package test.java.sessionFactory;

import java.util.List;import org.apache.catalina.startup.Catalina;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.service.impl.ServiceUuserImpl;

import hibernate.Carriage;

public class SessionTest {

	private ApplicationContext ctx;
	private ServiceUuserImpl xxxxx; 
	SessionFactory sessionFactory = null;

	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testSessionFactory() {
	sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
	System.out.println(sessionFactory);
//		xxxxx = (ServiceUuserImpl) ctx.getBean("uuserService");
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void test3() {
		sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		System.out.println(sessionFactory.openSession());
	}

	@Test
	public void test2() throws Exception {
		sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		List<Carriage> carriageList = session.createQuery("from Carriage d  where d.train.id = ?")
				.setParameter(0, "k31").list();
		
		for (Carriage carriage : carriageList) {
			System.out.println(carriage.toString());
		}
		
		transaction.commit();
		
	}
}
