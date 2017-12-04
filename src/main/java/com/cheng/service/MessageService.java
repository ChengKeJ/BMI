package com.cheng.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cheng.daoimpl.MessageDaoImpl;
import com.cheng.domain.Message;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class MessageService {

	private MessageDaoImpl messageDaoImpl;

	public void setMessageDaoImpl(MessageDaoImpl messageDaoImpl) {
		this.messageDaoImpl = messageDaoImpl;
	}

	// ��ѯ������Ϣ
	public List<Message> showAll() {
		return messageDaoImpl.serachAll();
	}

	// ����id ɾ����¼
	public boolean delete(int id) {

		int deleteByid = messageDaoImpl.deleteByid(id);
		if (deleteByid > 0) {
			return true;

		} else {
			return false;
		}
	}

	// �����¼
	public void record(double height, double weight) {
		messageDaoImpl.insert(height, weight);

	}

	public Message find() {
		return messageDaoImpl.serachLast();

	}

}
