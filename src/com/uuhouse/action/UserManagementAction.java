package com.uuhouse.action;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.uuhouse.hibernate.HibernateSessionFactory;
import com.uuhouse.bean.User;
import com.uuhouse.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserManagementAction extends ActionSupport implements ModelDriven<User> {	
	private static final long serialVersionUID = 3679433067515819166L;
	User user= new User();
	UserDAO dao =new UserDAO();
	List<User> s=new LinkedList<User>();
	HttpServletRequest request = ServletActionContext.getRequest();
	List<User> ss=new LinkedList<User>();
	int currentPage=1;
	int pageCount=1;
	
	
	
	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public List<User> getSs() {
		return ss;
	}


	public void setSs(List<User> ss) {
		this.ss = ss;
	}


	public User getModel() {
		return user;
	}
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserDAO getDao() {
		return dao;
	}


	public void setDao(UserDAO dao) {
		this.dao = dao;
	}


	public List<User> getS() {
		return s;
	}


	public void setS(List<User> s) {
		this.s = s;
	}


	public String add(){
		dao.save(user);
		return "tolist";
	}
	
	public String delete(){
		int s = (int) request.getSession().getAttribute("power");
		if(s == 2)
		{
		dao.delete((User)HibernateSessionFactory.getSession()
				.get(User.class,new Integer(user.getId())));
		return "tolist";
		}
		else
			request.getSession().setAttribute("emsg","您的权限不够！");
			return "error";
	}
	
	@SuppressWarnings("unchecked")
	public String list(){	
		if (currentPage < 1) {
			currentPage = 1;
		}
		s=dao.findAll();
		
		int count = s.size();
		
		if (count % 8 != 0) {
			pageCount = count / 8 + 1;
		} else
			pageCount = count / 8;
		if(currentPage >pageCount)
			currentPage=pageCount;
		for(int i= (currentPage-1)*8;i<currentPage*8;i++){
			if(i>=count||i<0)
				break;
			ss.add(s.get(i));
		}
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("currentPage", currentPage);
		return "list";

	}
	
	@SuppressWarnings("unchecked")
	public String findone(){
		ss=dao.findByUsername(user.getUsername());
		return "list";
		
	}
	
	public String toadd(){
		int s = (int) request.getSession().getAttribute("power");
		if(s==1||s==6)
		{
		return "toadd";
		}
		else
			request.getSession().setAttribute("emsg","您的权限不够！");
		return "error";
	}
	
	public String toupdate(){
		int s = (int) request.getSession().getAttribute("power");
		if(s==1||s==6)
		{
		user=(User)HibernateSessionFactory.getSession().get(User.class,new Integer(user.getId()));
		return "toupdate";
		}
		else
			request.getSession().setAttribute("emsg","您的权限不够！");
			return "error";
	}
	
	public String update(){
		User newp = (User)HibernateSessionFactory.getSession()
				.get(User.class,new Integer(user.getId()));
//		System.out.println(newp.getId());
		newp.setId(user.getId());
		newp.setUid(user.getUid());
		newp.setUsername(user.getUsername());
		newp.setPassword(user.getPassword());
		newp.setPower(user.getPower());
		dao.update(newp);
		return "tolist";
	}
}
