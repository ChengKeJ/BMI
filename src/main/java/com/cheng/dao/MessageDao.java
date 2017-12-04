package com.cheng.dao;

import java.util.List;

import com.cheng.domain.Message;

public interface MessageDao {
	//查看所有信息
	public List<Message> serachAll();
	
	//根据id 删除记录
	public int deleteByid(int id);
	
	//插入记录
	public  void insert(double height,double weight);
	
	public  Message serachLast();
}
