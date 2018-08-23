package pjw.deal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pjw.basket.dao.basket.BasketDao;
import pjw.basket.dao.basket.BasketDaoImpl;
import pjw.basket.model.BasketListItem;
import yjk.join.model.Member;

/**
 * Servlet implementation class ProductController
 */
@WebServlet(name = "DealController", 
			urlPatterns = {					
					"/product_buy",//구매화면 노출
					"/dealError",//비정상 거래화면 접근
					"/dealInsert" })//구매요청 처리
public class DealController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BasketDao dao = new BasketDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		System.out.println("action:" + action);

		if (action.equals("product_buy")) {			
			
		} else if (action.equals("dealError")) {			
			
		} else if (action.equals("dealInsert")) {			
			
		} 

		String requestUrl = null;

		if (action.equals("product_buy")) {
			requestUrl = "/member/pjw/view/deal/jsp/dealPage.jsp";	
		} else if (action.equals("dealError")) {			
			requestUrl = "/member/pjw/view/deal/jsp/dealErrorPage.jsp";	
		} else if (action.equals("dealInsert")) {
			requestUrl = "/member/pjw/view/deal/jsp/dealcompletePage.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(requestUrl);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
