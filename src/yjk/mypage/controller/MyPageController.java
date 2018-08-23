package yjk.mypage.controller;

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
import yjk.mypage.util.MyPageDao;
import yjk.mypage.util.MyPageDaoImpl;

/**
 * Servlet implementation class JoinController
 */
@WebServlet(name = "MyPageController", urlPatterns = {
"/userUpdate","/userCheck","/update_user","/ok"})
public class MyPageController extends HttpServlet {
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
		if(action.equals("userCheck")) {
			request.setCharacterEncoding("utf-8");
			String pw = request.getParameter("password").trim();
			MyPageDao mpd = new MyPageDaoImpl();
			boolean pck_result = mpd.PasswordCheck(pw);
			System.out.println(pck_result);
			if(pck_result==true) {
				
			}else if(pck_result == false){
				action = "error";
				message = "비밀번호를 다시 확인하세요.";
				request.setAttribute("message", message);
			}
		}else if(action.equals("userUpdate")) {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id").trim();
			System.out.println(id);
			String pw = request.getParameter("password1").trim();
			System.out.println(pw);
			String name = request.getParameter("name").trim();
			System.out.println(name);
			String phone = request.getParameter("phone").trim();
			System.out.println(phone);
			char YN= '\0';
			char YN2= '\0';
			if(request.getParameter("Check1") != null &&request.getParameter("Check1").trim().equals("Y")) {
				YN =  'Y';
			}else {
				YN = 'N';
			}
			System.out.println(YN);
			if(request.getParameter("Check4") != null && request.getParameter("Check4").trim().equals("Y")) {
				YN2 =  'Y';
			}else {
				YN2 = 'N';
			}
			System.out.println(YN2);
			MyPageDao mpd = new MyPageDaoImpl();
			boolean userUpdate_result = mpd.userUpdate(id, pw, name, phone, YN, YN2);
			System.out.println(userUpdate_result);
			if(!userUpdate_result) {
				action = "error";
				message = "회원정보 수정이 실패하였습니다.";
				request.setAttribute("message", message);
			}else {
				message = "회원정보가 수정되었습니다.";
				request.setAttribute("message", message);
			}		
		}
		String dispatchUrl = null;
		if(action.equals("userCheck")) {
			dispatchUrl = "/member/yjk/view/jsp/MyPage_Update.jsp";
		}else if(action.equals("error")) {
			dispatchUrl = "/member/yjk/view/jsp/MyPage_Check.jsp";
		}else if(action.equals("userUpdate")) {
			dispatchUrl = "/member/yjk/view/jsp/MyPage_Update_Success.jsp";
		}else if(action.equals("update_user")) {
			dispatchUrl = "/member/yjk/view/jsp/MyPage_Check.jsp";
		}else if(action.equals("ok")) {
			dispatchUrl = "/member/yjk/view/jsp/MyPage.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(request, response);
	}
}
