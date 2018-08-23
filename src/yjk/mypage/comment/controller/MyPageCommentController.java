package yjk.mypage.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import yjk.mypage.comment.model.s_p_comment;
import yjk.mypage.comment.util.MyPageCommentDao;
import yjk.mypage.comment.util.MyPageCommentDaoImpl;
import yjk.mypage.util.MyPageDao;
import yjk.mypage.util.MyPageDaoImpl;

/**
 * Servlet implementation class JoinController
 */
@WebServlet(name = "MyPageCommentController", urlPatterns = {
"/buyCommentInsert","/buyCommentView", "/mypage_request"})
public class MyPageCommentController extends HttpServlet {
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
		String dispatchUrl = null;
		if(action.equals("buyCommentInsert")) {
			request.setCharacterEncoding("utf-8");
			s_p_comment comment = new s_p_comment();
			comment.setCtitle(request.getParameter("ctitle"));
			comment.setCcontent(request.getParameter("ccontent"));
			comment.setPid(Integer.parseInt(request.getParameter("pid")));
			comment.setDid(Integer.parseInt(request.getParameter("did")));
			MyPageCommentDao mcd = new MyPageCommentDaoImpl();
			mcd.commentInsert(comment);
		}else if(action.equals("buyCommentView")) {
			request.setCharacterEncoding("utf-8");
			s_p_comment comment = new s_p_comment();
			comment.setPid(Integer.parseInt(request.getParameter("pid")));
			comment.setDid(Integer.parseInt(request.getParameter("did")));
			comment.setPname(request.getParameter("pname"));
			request.setAttribute("comment", comment);
			MyPageCommentDao mcd = new MyPageCommentDaoImpl();
			int result = mcd.select_comment(comment.getDid(), comment.getPid());
			if(result != 0) {
				s_p_comment spc =mcd.contenttitle(result);
				String content = spc.getCcontent();
				String title  = spc.getCtitle();
				request.setAttribute("content", content);
				request.setAttribute("title", title);
				message="이미 등록하신 상품평입니다. 수정하시려면 다시 입력해주세요!";
				request.setAttribute("message", message);
			}
		}
		
		if(action.equals("buyCommentInsert")) {
			dispatchUrl = "mypageBuy";
		}else if(action.equals("buyCommentView")) {
			dispatchUrl = "/member/yjk/view/jsp/MyPage_Buy_Comment.jsp";
		}else if(action.equals("mypage_request")) {
			dispatchUrl = "/member/yjk/view/jsp/MyPage.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(request, response);
	}
}
