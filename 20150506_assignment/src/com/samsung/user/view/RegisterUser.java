package com.samsung.user.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.user.impl.HomeUserDAO;
import com.samsung.user.vo.HUserVO;

@WebServlet("/registerUser.do")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		int gender = Integer.parseInt(request.getParameter("gender"));
		
		HUserVO user = new HUserVO(name, password, email, age, gender);
		
		HomeUserDAO dao = new HomeUserDAO();
		dao.insertUser(user);
		
		response.sendRedirect("userList.do");
	
	}

}
