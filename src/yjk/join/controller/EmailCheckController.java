package yjk.join.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yjk.join.util.JoinDao;
import yjk.join.util.JoinDaoImpl;




@WebServlet(name = "EmailCheckController", urlPatterns = {
		"/Validate"})
public class EmailCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		int lastIndex = url.lastIndexOf("/");
		String action = url.substring(lastIndex+1);
		if(action.equals("Validate")) {
			request.setCharacterEncoding("utf-8");
			String userEmail = request.getParameter("userEmail").trim();
			JoinDao joindao = new JoinDaoImpl();
			boolean mid_check_result = joindao.selectByMid(userEmail);
			PrintWriter out = response.getWriter();
			if(mid_check_result) {
				out.println("false");
			}else{
				out.println("true");
	        }  
		}
	}

}
