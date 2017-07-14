package test.java.sessionFactory;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.service.iservice.IPriceService;
import com.java.service.iservice.IStationService;

import hibernate.Price;
import hibernate.Station;

public class ServiceLoginImplTest {
	private IPriceService priceService;
	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		priceService =  (IPriceService) ctx.getBean("priceService");
	}

	

	
	
	@Test
	public void testDelete() {
		Price price = new Price(223, 3, 3, 3, 0.4, 3);
		System.out.println(priceService.save(price));
	}

	@Test
	public void testUpdate() {
	
	}

	@Test
	public void testFindAll() {
	
	}

	@Test
	public void testFindById() {

	}

}
