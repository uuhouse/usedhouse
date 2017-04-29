package com.uuhouse.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.uuhouse.dao.UserDAO;

public class UserCheckAction extends ActionSupport {

	private static final long serialVersionUID = -5350620306076311166L;
	HttpServletRequest request = ServletActionContext.getRequest();
	UserDAO dao = new UserDAO();
	
	
	public String checkLogin() {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		
	}
}
