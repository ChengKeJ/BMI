package com.cheng.dao;

import java.util.List;

import com.cheng.domain.Message;

public interface MessageDao {
	//�鿴������Ϣ
	public List<Message> serachAll();
	
	//����id ɾ����¼
	public int deleteByid(int id);
	
	//�����¼
	public  void insert(double height,double weight);
	
	public  Message serachLast();
}
