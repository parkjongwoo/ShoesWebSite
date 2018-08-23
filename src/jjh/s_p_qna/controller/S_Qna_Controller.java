package jjh.s_p_qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jjh.s_p_qna.dao.S_P_QnaImpl;
import jjh.s_p_qna.model.S_P_Qna;
import jjh.s_product.dao.S_ProductImpl;
import jjh.s_product.model.S_Product;
import yjk.join.model.Member;



@WebServlet({"/target_p_qna", "/p_qna_list", "/s_p_qna_form","/s_p_qna_insert"})
public class S_Qna_Controller extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String tempURL = null;
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		// URL패턴을 잘라냄
		
		// URL패턴별 작업
		if(action.equals("p_qna_test")) {
			
		}// 대상 상품 Q&A 가져오기
		else if(action.equals("target_p_qna")) {
			int pid = Integer.parseInt(request.getParameter("target_pid"));
			
			S_P_QnaImpl qnaImpl = new S_P_QnaImpl();
			List<S_P_Qna> list = qnaImpl.selectQna(pid);
			request.setAttribute("target_qna", list);
			
		}else if(action.equals("s_p_qna_form")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			S_ProductImpl spi = new S_ProductImpl();
			S_Product product = spi.selectProductByid(pid);
			
			request.setAttribute("target_product", product);
		
			
		}else if(action.equals("s_p_qna_insert")) {
			int pid = Integer.parseInt(request.getParameter("pid"));
			String qtitle = request.getParameter("qtitle");
			String qcontent = request.getParameter("qcontent");
			// 세션에서 사용자 객체 가져오기
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("member");
			
			S_P_Qna qna = new S_P_Qna();
			qna.setQtitle(qtitle);
			qna.setQcontent(qcontent);
			qna.setMid(member.getMid());
			//qna.setMid("ganghyuk@gmail.com");
			qna.setPid(pid);
			S_P_QnaImpl qnaImpl = new S_P_QnaImpl();
			qnaImpl.insertQna(qna);
			tempURL="product_page?target_pid=" + qna.getPid();
		}
		
		
		// ---- 페이지 이동 ----
		String dispatchUrl = null;
		if(action.equals("p_qna_test")) {
			dispatchUrl = "/member/jjh/view/jsp/s_product.jsp";
		}else if(action.equals("target_p_qna")) {
			dispatchUrl = "/member/jjh/data/xml/target_qna.jsp";
		}else if(action.equals("s_p_qna_form")) {
			dispatchUrl = "/member/jjh/view/jsp/s_p_qna_form.jsp";
		}else if(action.equals("s_p_qna_insert")) {
			dispatchUrl = tempURL;
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
		rd.forward(request, response);
	}

}
