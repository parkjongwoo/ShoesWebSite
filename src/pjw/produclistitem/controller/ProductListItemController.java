package pjw.produclistitem.controller;

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
@WebServlet(name = "productListItemController", urlPatterns = { "/main", "/productListItemSelectNew" })
public class ProductListItemController extends HttpServlet {
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

		} else if (action.equals("productListItemSelectNew")) {
			List<ProductListItem> list = dao.selectNewItems();
			request.setAttribute("productListNew", list);

		}

		String requestUrl = null;

		if (action.equals("main")) {
			requestUrl = "/member/pjw/view/jsp/main.jsp";	
		} else if (action.equals("productListItemSelectNew")) {
			requestUrl = "/member/pjw/view/jsp/response_productList.jsp";
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
