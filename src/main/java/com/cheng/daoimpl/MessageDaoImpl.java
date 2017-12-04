package com.cheng.daoimpl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.cheng.dao.MessageDao;
import com.cheng.domain.Message;

public class MessageDaoImpl implements MessageDao {

	private SessionFactory sessionFactory;

	private Message message;

	public void setMessage(Message message) {
		this.message = message;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Message> serachAll() {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Message ");
		List<Message> list = query.list();
		session.close();
		return list;
	}

	public int deleteByid(int id) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("delete from Message m where m.id=?");
		query.setParameter(0, id);

		int executeUpdate = query.executeUpdate();
		transaction.commit();
		session.close();
		return executeUpdate;

	}

	public void insert(double height, double weight) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date1 = simpleDateFormat.format(date);
		message.setWeight(weight);
		message.setDate(date1);
		message.setHigh(height);
		message.setBmi(weight / ((height / 100) * (height / 100)));

		session.save(message);

		transaction.commit();
		session.close();

	}

	public Message serachLast() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Message");
		List<Message> list = query.list();
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				Message message2 = list.get(i);
				session.close();
				return message2;
			}
		}
		session.close();
		return null;

	}

}
