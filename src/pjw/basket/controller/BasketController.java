package pjw.basket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pjw.produclistitem.dao.productlist.ProductListItemDao;
import pjw.produclistitem.dao.productlist.ProductListItemDaoImpl;
import pjw.produclistitem.model.ProductListItem;

/**
 * Servlet implementation class ProductController
 */
@WebServlet(name = "BasketController", 
			urlPatterns = {
					"/basketPage",
					"/basketList",
					"/basketInsert",
					"/basketDelete",
					"/basketUpdate" })
public class BasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductListItemDao dao = new ProductListItemDaoImpl();

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

		if (action.equals("main")) {

		} else if (action.equals("productlistbycategory")) {
			String param_cid = request.getParameter("cid");
			int cid = 1;
			try {
				if(param_cid!=null)
					cid=Integer.parseInt(param_cid);
			} catch (NumberFormatException e) {
				cid = 1;
				e.printStackTrace();
			}
			List<ProductListItem> list = dao.selectCateItems(cid);
			request.setAttribute("productList", list);
			if(list.size()>0)
				request.setAttribute("cname", list.get(0).getCname());
			
			
		} else if (action.equals("productlistbykeyword")) {
			String param_keyword = request.getParameter("keyword");
			List<ProductListItem> list = dao.selectByKeyword(param_keyword);
			request.setAttribute("productList", list);
			request.setAttribute("keyword", param_keyword);
			
		} else if (action.equals("productListItemSelectNew")) {
			List<ProductListItem> list = dao.selectNewItems();
			request.setAttribute("productList", list);

		} else if (action.equals("productListItemSelectPop")) {
			List<ProductListItem> list = dao.selectPopItems();
			request.setAttribute("productList", list);
		}

		String requestUrl = null;

		if (action.equals("main")) {
			requestUrl = "/member/pjw/view/productList/jsp/main.jsp";	
		} else if (action.equals("productlistbycategory")) {
			requestUrl = "/member/pjw/view/productList/jsp/categoryListPage.jsp";
		} else if (action.equals("productlistbykeyword")) {
			requestUrl = "/member/pjw/view/productList/jsp/searchByKeywordPage.jsp";
		} else if (action.equals("productListItemSelectNew")) {
			requestUrl = "/member/pjw/view/productList/jsp/response_json_productList.jsp";
		} else if (action.equals("productListItemSelectPop")) {
			requestUrl = "/member/pjw/view/productList/jsp/response_json_productList.jsp";
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
