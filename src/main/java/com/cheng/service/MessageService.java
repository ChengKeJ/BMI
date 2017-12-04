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

	// 查询所有信息
	public List<Message> showAll() {
		return messageDaoImpl.serachAll();
	}

	// 根据id 删除记录
	public boolean delete(int id) {

		int deleteByid = messageDaoImpl.deleteByid(id);
		if (deleteByid > 0) {
			return true;

		} else {
			return false;
		}
	}

	// 保存记录
	public void record(double height, double weight) {
		messageDaoImpl.insert(height, weight);

	}

	public Message find() {
		return messageDaoImpl.serachLast();

	}

}
