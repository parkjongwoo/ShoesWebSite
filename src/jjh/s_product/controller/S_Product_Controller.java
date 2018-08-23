package jjh.s_product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jjh.s_product.dao.S_ProductImpl;
import jjh.s_product.model.S_Product;



@WebServlet({"/product_page","/target_product"})
public class S_Product_Controller extends HttpServlet {


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
		if(action.equals("product_page")) {
			//int pid = 2;
			if(request.getParameter("target_pid") != null) {
				int pid = Integer.parseInt(request.getParameter("target_pid"));
				request.setAttribute("pid", pid);
			}else {
				HttpSession session = request.getSession();
				request.setAttribute("pid", (Integer)session.getAttribute("pid"));
			}
			
			
			
			
		}
		// 대상 상품 정보 가져오기
		else if(action.equals("target_product")) {
			int pid = 0;
			// 전 페이지에서 target_pid로 가져와서 검색
			if(request.getParameter("target_pid") != null) {
			pid = Integer.parseInt(request.getParameter("target_pid"));
			}else {
				pid = (Integer)request.getAttribute("pid");
			}
			S_ProductImpl spi = new S_ProductImpl();
			S_Product product = spi.selectProductByid(pid);
			
			request.setAttribute("target_product", product);
		
		}
		
		// ---- 페이지 이동 ----
		String dispatchUrl = null;
		if(action.equals("product_page")) {
			dispatchUrl = "/member/jjh/view/jsp/s_product.jsp";
		}
		else if(action.equals("target_product")) {
			dispatchUrl = "/member/jjh/data/xml/target_product.jsp";
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
		rd.forward(request, response);
	}

}
