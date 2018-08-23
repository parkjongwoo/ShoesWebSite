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
import pjw.deal.model.DProduct;
import pjw.produclistitem.model.ProductListItem;

/**
 * Servlet implementation class ProductController
 */
@WebServlet(name = "DealController", 
			urlPatterns = { 
					"/product_buy",//구매화면 노출
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
			String pid = request.getParameter("pid");
			String quantity = request.getParameter("quantity");
			
			List<BasketListItem> sessionlist = (List<BasketListItem>)request.getSession().getAttribute("basketList");
			System.out.println("sessionlist:"+sessionlist);
//			if(pid != null && quantity != null) {//상품상세의 바로구매-- 상품정보를 채워 장바구니와 형식을 일치시키자
//				
//			}else if(basketItems != null) {//장바구니에서 구매-- 세션에서 긁어 오자
//				
//			}
		} else if (action.equals("dealInsert")) {			
			
		} 

		String requestUrl = null;

		if (action.equals("product_buy")) {
			requestUrl = "/member/pjw/view/deal/jsp/dealPage.jsp";	
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
