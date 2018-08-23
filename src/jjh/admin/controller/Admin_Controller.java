package jjh.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jjh.dao.Query;
import jjh.s_p_comment.dao.S_P_CommentImpl;
import jjh.s_p_comment.model.S_P_Comment;
import jjh.s_p_qna.dao.S_P_QnaImpl;
import jjh.s_p_qna.model.S_P_Qna;
import jjh.s_product.dao.S_ProductImpl;
import jjh.s_product.model.S_Product;
import jjh.s_qna.dao.S_QnaImpl;
import jjh.s_qna.model.S_Qna;
import jjh.service.page.PageGroupResult;
import jjh.service.page.PageManager;
import jjh.service.sql.PagingSql;



@WebServlet({"/admin_main","/admin_qnaList","/qna_answerForm","/admin_UserQnaList","/admin_answerUserQna","/UserQna_answerForm","/admin_answerComment"})
public class Admin_Controller extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	private PageGroupResult pager(int requestPage) {
		PageManager pm = new PageManager(requestPage);
		PageGroupResult result = pm.getPageGroupResult(PagingSql.SELECT_ALL_COUNT_S_P_QNA);
		
		return result;
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		// URL패턴을 잘라냄
		
		// URL패턴별 작업
		if(action.equals("admin_main")) {
			// QNA 불러오기
			S_P_QnaImpl qnaImpl = new S_P_QnaImpl();
			List<S_P_Qna> qnaList = qnaImpl.selectALLQna();
			
			// 1:1문의 불러오기
			S_QnaImpl impl = new S_QnaImpl();
			List<S_Qna> list = impl.selectAll();
			request.setAttribute("s_p_qna_list", qnaList);
			request.setAttribute("s_qna_list", list);
			
		}else if(action.equals("admin_qnaList")) {
			int requestPage = 1;
			
			try {
				requestPage = Integer.parseInt(request.getParameter("reqPage"));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			// QNA 불러오기
			S_P_QnaImpl qnaImpl = new S_P_QnaImpl();
			List<S_P_Qna> qnaList = qnaImpl.selectPage(requestPage);
			request.setAttribute("s_p_qna_list", qnaList);
			request.setAttribute("pageGroup", pager(requestPage));
		}else if(action.equals("qna_answerForm")) {
			int qid = Integer.parseInt(request.getParameter("qid"));
			S_P_QnaImpl qnaImpl = new S_P_QnaImpl();
			S_P_Qna qna = qnaImpl.targetPid(qid);
			request.setAttribute("qid", qid);
			request.setAttribute("targetqna", qna);
		}else if(action.equals("admin_answerComment")) {
			// 세션에서 사용자 객체 가져오기
			HttpSession session = request.getSession();
			//Member member = session.getAttribute("member");
			int qid = Integer.parseInt(request.getParameter("qid"));
			int pid = Integer.parseInt(request.getParameter("pid"));
			String pretitle = request.getParameter("pretitle");
			String qcontent = request.getParameter("qcontent");
			S_P_Qna qna = new S_P_Qna();
			qna.setQtitle("RE : "+pretitle);
			qna.setQcontent(qcontent);
		
			qna.setMid("shoong1999@gmail.com");
			//qna.setMid(member.getMid());
			qna.setQparent(qid);
			qna.setPid(pid);
			S_P_QnaImpl qnaImpl = new S_P_QnaImpl();
			qnaImpl.answerQna(qna);
			
		}
		//---------- end of s_p_qna
		
		else if(action.equals("admin_UserQnaList")) {
			int requestPage = Integer.parseInt(request.getParameter("reqPage"));
			// QNA 불러오기
			S_QnaImpl qnaImpl = new S_QnaImpl();
			List<S_Qna> qnaList = qnaImpl.pagerQna(requestPage);
			request.setAttribute("s_qna_list", qnaList);
			request.setAttribute("pageGroup", pager(requestPage));
		}else if(action.equals("UserQna_answerForm")) {
			int qid = Integer.parseInt(request.getParameter("qid"));
			S_QnaImpl qnaImpl = new S_QnaImpl();
			S_Qna qna = qnaImpl.targetQna(qid);
			request.setAttribute("qid", qid);
			request.setAttribute("targetqna", qna);
		}else if(action.equals("admin_answerUserQna")) {
			int qid = Integer.parseInt(request.getParameter("qid"));
			String preTitle = request.getParameter("pretitle");
			String title = "RE : " + preTitle;
			S_QnaImpl qnaImpl = new S_QnaImpl();
			
			S_Qna qna = new S_Qna();
			qna.setQcontent(request.getParameter("qcontent"));
			qna.setQparent(qid);
			qna.setQtitle(title);
			qna.setMid("shoong1999@gmail.com");
	
			qnaImpl.answerQna(qna);
			
		}
		
		
		
		
		
		// ---- 페이지 이동 ----
		String dispatchUrl = null;
		if(action.equals("admin_main")) {
			dispatchUrl = "/member/jjh/view/jsp/admin_main.jsp";
		}else if(action.equals("admin_qnaList")) {
			dispatchUrl = "/member/jjh/view/jsp/admin_qna_list.jsp";
		}else if(action.equals("qna_answerForm")) {
			dispatchUrl = "/member/jjh/view/jsp/qna_answerForm.jsp";
		}else if(action.equals("admin_answerComment")) {
			dispatchUrl = "admin_qnaList?reqPage=1";
		}
		//---------- end of s_p_qna
		else if(action.equals("admin_UserQnaList")) {
			dispatchUrl = "/member/jjh/view/jsp/admin_s_qna_list.jsp";
		}if(action.equals("UserQna_answerForm")) {
			dispatchUrl = "/member/jjh/view/jsp/s_qna_answerForm.jsp";
		}else if(action.equals("admin_answerUserQna")) {
			dispatchUrl = "admin_UserQnaList?reqPage=1";
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
		rd.forward(request, response);
	}

}
