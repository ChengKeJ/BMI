package com.cheng.daoimpl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cheng.domain.Message;

public class MessageDaoImplTest {

	@Test
	public void testSerachLast() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageDaoImpl bean = context.getBean("messageDaoImpl",MessageDaoImpl.class);
		Message serachLast = bean.serachLast();
		System.out.println(serachLast);
	
	}

}
