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
import yjk.join.model.Member;

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
					"/basketClear",
					"/basketLoginError",
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
			Member m = (Member)request.getSession().getAttribute("member");
			String mid = m.getMid();
			List<BasketListItem> list = dao.selectAllItems(mid);
			
//			System.out.println(list);
			request.getSession().setAttribute("basketList", list);
			
		} else if (action.equals("basketListJson")) {
			Member m = (Member)request.getSession().getAttribute("member");
			String mid = m.getMid();
			List<BasketListItem> list = dao.selectAllItems(mid);
			request.getSession().setAttribute("basketList", list);
			
		} else if (action.equals("basketInsertJson")) {
			Member m = (Member)request.getSession().getAttribute("member");
			String mid = m.getMid();
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
				System.out.println("error:"+e.getMessage());
			}
			request.setAttribute("result", result);
			
		} else if (action.equals("basketDeleteJson")) {
			Member m = (Member)request.getSession().getAttribute("member");
			String pid = request.getParameter("pid");
			String mid = m.getMid();
			String idx = request.getParameter("idx");
//			System.out.println("pid:"+pid+" mid:"+mid+" idx:"+idx);
			List<BasketListItem> sessionlist = (List<BasketListItem>)request.getSession().getAttribute("basketList");
			boolean result = false;
			if(pid != null && mid != null && idx != null) {
				try {	
					if(sessionlist!=null && sessionlist.size()>0) {
						sessionlist.remove(Integer.parseInt(idx));
						request.getSession().setAttribute("basketList",sessionlist);						
					}
					result = dao.deleteByPid(mid, Integer.parseInt(pid));
				} catch (NumberFormatException e) {
					System.out.println("error:"+e.getMessage());
				}
				request.setAttribute("result", result);
			}
		} else if (action.equals("basketUpdateJson")) {
			Member m = (Member)request.getSession().getAttribute("member");
			String mid = m.getMid();
			String pids = request.getParameter("pid");
			String quantitys = request.getParameter("quantity");
			String idxs = request.getParameter("idx");
			System.out.println("pid:"+pids+" mid:"+mid+" quantitys:"+quantitys);
			List<BasketListItem> sessionlist = (List<BasketListItem>)request.getSession().getAttribute("basketList");
			
			boolean result = false;
			if(pids != null && mid != null && idxs != null) {
				try {
					int quantity = Integer.parseInt(quantitys);
					int pid = Integer.parseInt(pids);
					int idx = Integer.parseInt(idxs);
					if(sessionlist!=null && sessionlist.size()>0) {
						sessionlist.get(idx).setBquantity(quantity);
						request.getSession().setAttribute("basketList",sessionlist);						
					}
					Basket basket = new Basket();
					basket.setMid(mid);
					basket.setBquantity(quantity);
					basket.setPid(pid);
					result = dao.update(basket);
				} catch (NumberFormatException e) {
					System.out.println("error:"+e.getMessage());
				}
				request.setAttribute("result", result);
			}
		}else if(action.equals("basketClear")) {
			Member m = (Member)request.getSession().getAttribute("member");
			String mid = m.getMid();			
			request.getSession().removeAttribute("basketList");
			if(mid!=null) {
				boolean result = dao.clearBasketByMid(mid);
				request.setAttribute("result", result);
			}
		}

		String requestUrl = null;

		if (action.equals("product_cart")) {
			requestUrl = "/member/pjw/view/basket/jsp/basketListPage.jsp";	
		} else if (action.equals("basketListJson")) {
			requestUrl = "/member/pjw/view/basket/jsp/response_json_basketList.jsp";
		} else if (action.equals("basketInsertJson")) {
			requestUrl = "/member/pjw/view/basket/jsp/response_json_basketInsert.jsp";
		} else if (action.equals("basketDeleteJson")) {
			requestUrl = "/member/pjw/view/basket/jsp/response_json_basketResult.jsp";
		} else if (action.equals("basketUpdateJson")) {
			requestUrl = "/member/pjw/view/basket/jsp/response_json_basketResult.jsp";
		} else if(action.equals("basketClear")) {
			requestUrl = "/member/pjw/view/basket/jsp/response_json_basketResult.jsp";
		} else if(action.equals("basketLoginError")) {
			requestUrl = "/member/pjw/view/basket/jsp/response_json_login_error.jsp";
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
