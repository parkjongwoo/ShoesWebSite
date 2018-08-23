package yjk.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yjk.join.model.Member;
import yjk.login.util.LoginDao;
import yjk.login.util.LoginDaoImpl;

/**
 * Servlet implementation class JoinController
 */
@WebServlet(name = "LoginController", urlPatterns = {"/start","/userLogin","/userLogout"})
public class LoginController extends HttpServlet {
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
		String message = "";
		boolean flag = false;
		String lastURL = null;
		if(action.equals("userLogin")) {
			
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			
			if(request.getAttribute("lastURL") != null) {
				flag=true;
				lastURL = (String)request.getAttribute("lastURL");
			}
			String id = request.getParameter("userEmail").trim();
			String pw = request.getParameter("userPassword").trim();
			LoginDao ldo = new LoginDaoImpl();
			Member member = ldo.loginCheck(id, pw);
			if(member.getValidate()==1 && member.getMauth() == 'N') {
				session.removeAttribute("adminmember");
				session.setAttribute("member", member);
				session.setAttribute("commonmember", "member");
			}else if(member.getValidate()==1 && member.getMauth() == 'A') {
				session.removeAttribute("commonmember");
				session.setAttribute("member", member);
				session.setAttribute("adminmember", "admin");
			}
			
			else if(member.getValidate()==-1) {
				action = "error";
				message = "아이디 또는 비밀번호를 다시 확인하세요.\r\n" + 
						" 등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.";
				request.setAttribute("message", message);
			}else {
				action = "error";
				message = "아이디 또는 비밀번호를 다시 확인하세요.\r\n" + 
						"등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.";
				request.setAttribute("message", message);
			}
		}else if(action.equals("userLogout")) {
			HttpSession session = request.getSession();
			session.invalidate();
		}
		String dispatchUrl = null;
		if(action.equals("userLogin") && flag == true) {
			dispatchUrl = lastURL;
		}else if(action.equals("userLogin")) {
			dispatchUrl = "mainPage";
		}
		
		else if(action.equals("error")) {
			dispatchUrl = "/member/yjk/view/jsp/Login.jsp";
		}else if(action.equals("userLogout")) {
			dispatchUrl = "/member/yjk/view/jsp/Login.jsp";
		}else if(action.equals("start")) {
			dispatchUrl = "/member/yjk/view/jsp/Login.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(request, response);
	}
}
