package com.cheng.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;


import com.cheng.domain.Message;
import com.cheng.service.MessageService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;



public class ShowAction extends ActionSupport {

	private static final long serialVersionUID = 1L;


	private MessageService messageService;

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	// 展示所有信息到前端
	public void showAll() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Message> messages = messageService.showAll();

		Gson gson = new Gson();

		String json = gson.toJson(messages);
		response.getWriter().println(json);
	}

	// 根据前端传过来的id 删除记录
	public void deleteById() throws IOException {

		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		int parseInt = Integer.parseInt(id);
		boolean delete = messageService.delete(parseInt);

		String delete2=delete+" ";
		Gson gson = new Gson();
		String json = gson.toJson(delete2);
		System.out.println(delete2);
		response.getWriter().println(json);
	}
	
	//记录数据
	public void record() throws IOException {
	
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
	
		double height1 = Double.parseDouble(height);
		double weight1 = Double.parseDouble(weight);
		messageService.record(height1, weight1);	
		
	}
	//找最后一个值数据库中的
	public void findLast() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		Message find = messageService.find();
		Gson gson = new Gson();
		String json = gson.toJson(find);
		response.getWriter().println(json);
		
	}

}
