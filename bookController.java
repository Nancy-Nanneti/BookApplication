package com.bookstore.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.model.dao.book.BookDao;
import com.bookstore.model.dao.book.BookDaoImple;

@WebServlet("/bookController")
public class bookController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private BookDao dao=new BookDaoImple();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("showallbooks")) {
			request.setAttribute("books", dao.getAllBooks());
			RequestDispatcher rd=request.getRequestDispatcher("show.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
