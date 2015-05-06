package com.samsung.user.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.user.impl.HomeUserDAO;
import com.samsung.user.vo.HUserVO;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/userList.do")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HomeUserDAO dao = new HomeUserDAO();
		ArrayList<HUserVO> list = dao.getUserList();
		
		request.setAttribute("userList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/userList.jsp");
			
		rd.forward(request, response);
	
	}

}
