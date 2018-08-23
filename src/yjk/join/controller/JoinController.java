package yjk.join.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yjk.join.model.Member;
import yjk.join.util.JoinDao;
import yjk.join.util.JoinDaoImpl;

/**
 * Servlet implementation class JoinController
 */
@WebServlet(name = "JoinController", urlPatterns = {
"/userJoin","/join_request"})
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		int lastIndex = url.lastIndexOf("/");
		String action = url.substring(lastIndex+1);
		if(action.equals("userJoin")) {
			request.setCharacterEncoding("utf-8");
			Member member = new Member();
			member.setMid(request.getParameter("userEmail").trim());
			member.setMpw(request.getParameter("userPassword1").trim());
			member.setMname(request.getParameter("userName").trim());
			member.setMphone(request.getParameter("userPhone").trim());
			System.out.println(member.getMphone());
			if(request.getParameter("Check1") != null &&request.getParameter("Check1").trim().equals("Y")) {
				member.setMagree_email('Y');
			}else {
				member.setMagree_email('N');
			}
			System.out.println(member.getMagree_email());
			if(request.getParameter("Check4") != null && request.getParameter("Check4").trim().equals("Y")) {
				member.setMagree_sms('Y');
			}else {
				member.setMagree_sms('N');
			}
			System.out.println(member.getMagree_sms());
			JoinDao joindao = new JoinDaoImpl();
			boolean member_insert_result = joindao.member_insert(member);
			System.out.println(member_insert_result);
		}
		String dispatchUrl = null;
		if(action.equals("userJoin")) {
			dispatchUrl = "/member/yjk/view/jsp/JoinSuccess.jsp";
		}else if(action.equals("join_request")) {
			dispatchUrl = "/member/yjk/view/jsp/Join.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(request, response);
	}
}
