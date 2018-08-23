package pjw.basket.controller;

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
import pjw.basket.model.Basket;
import pjw.basket.model.BasketListItem;

/**
 * Servlet implementation class ProductController
 */
@WebServlet(name = "BasketController", 
			urlPatterns = {
					"/product_cart",//장바구니 목록 페이지
					"/basketListJson",//장바구니 목록 json data
					"/basketInsertJson",
					"/basketDeleteJson",
					"/basketUpdateJson",
					"/godeal"})//구매화면이동.
public class BasketController extends HttpServlet {
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
		
		if (action.equals("product_cart")) {
			
			
		} else if (action.equals("basketListJson")) {
			String mid = "ohhyuk@gmail.com";
			List<BasketListItem> list = dao.selectAllItems(mid);
			request.getSession().setAttribute("basketList", list);
			
		} else if (action.equals("basketInsertJson")) {
			String mid = "ohhyuk@gmail.com";
			String pid = request.getParameter("pid");
			String quantity = request.getParameter("quantity");
			boolean result = false;
			
			try {
				Basket basket = new Basket();
				basket.setMid(mid);
				basket.setBquantity(Integer.parseInt(quantity));
				basket.setPid(Integer.parseInt(pid));
				result = dao.insert(basket);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			request.setAttribute("result", result);
			
		} else if (action.equals("basketDeleteJson")) {
			String pid = request.getParameter("pid");
			String mid = request.getParameter("mid");
			String idx = request.getParameter("idx");
			System.out.println("pid:"+pid+" mid:"+mid+" idx:"+idx);
			List<BasketListItem> sessionlist = (List<BasketListItem>)request.getSession().getAttribute("basketList");
			boolean result = false;
			if(pid != null && mid != null && idx != null) {
				try {	
					if(sessionlist!=null) {
						sessionlist.remove(Integer.parseInt(idx));
						request.getSession().setAttribute("basketList",sessionlist);						
					}
					result = dao.deleteByPid(mid, Integer.parseInt(pid));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				request.setAttribute("result", result);
			}
		} else if (action.equals("basketUpdateJson")) {
			String pid = request.getParameter("pid");
			String mid = request.getParameter("mid");
			String quantity = request.getParameter("quantity");
			String idx = request.getParameter("idx");
			System.out.println("pid:"+pid+" mid:"+mid);
			List<BasketListItem> sessionlist = (List<BasketListItem>)request.getSession().getAttribute("basketList");
			boolean result = false;
			if(pid != null && mid != null && idx != null) {
				try {
					Basket basket = new Basket();
					basket.setMid(mid);
					basket.setBquantity(Integer.parseInt(quantity));
					basket.setPid(Integer.parseInt(pid));
					
					if(sessionlist!=null) {
						sessionlist.get(Integer.parseInt(idx)).setBquantity(basket.getBquantity());;
						request.getSession().setAttribute("basketList",sessionlist);						
					}
					result = dao.update(basket);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				request.setAttribute("result", result);
			}
		}

		String requestUrl = null;

		if (action.equals("product_cart")) {
			requestUrl = "/member/pjw/view/basket/jsp/basketListPage.jsp";	
		} else if (action.equals("basketListJson")) {
			requestUrl = "/member/pjw/view/basket/jsp/response_json_basketList.jsp";
		} else if (action.equals("basketInsertJson")) {
			requestUrl = "/member/pjw/view/basket/jsp/response_json_basketResult.jsp";
		} else if (action.equals("basketDeleteJson")) {
			requestUrl = "/member/pjw/view/basket/jsp/response_json_basketResult.jsp";
		} else if (action.equals("basketUpdateJson")) {
			requestUrl = "/member/pjw/view/basket/jsp/response_json_basketResult.jsp";
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
