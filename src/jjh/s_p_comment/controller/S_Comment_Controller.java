package jjh.s_p_comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jjh.s_p_comment.dao.S_P_CommentImpl;
import jjh.s_p_comment.model.S_P_Comment;
import jjh.s_p_qna.dao.S_P_QnaImpl;
import jjh.s_p_qna.model.S_P_Qna;
import jjh.s_product.dao.S_ProductImpl;
import jjh.s_product.model.S_Product;



@WebServlet({"/target_p_comment"})
public class S_Comment_Controller extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		// URL패턴을 잘라냄
		
		// URL패턴별 작업
		// 대상 상품 상품평 가져오기
		if(action.equals("target_p_comment")) {
			int pid = Integer.parseInt(request.getParameter("target_pid"));
			
			S_P_CommentImpl commentImpl = new S_P_CommentImpl();
			List<S_P_Comment> list = commentImpl.selectComment(pid);
			request.setAttribute("target_comment", list);
			
		}
		
		// ---- 페이지 이동 ----
		String dispatchUrl = null;
		if(action.equals("target_p_comment")) {
			dispatchUrl = "/member/jjh/data/xml/target_comment.jsp";
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
		rd.forward(request, response);
	}

}
