package yjk.mypage.buy.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import yjk.mypage.buy.model.s_deal;
import yjk.mypage.buy.model.s_deal_view;
import yjk.mypage.buy.util.MyPageBuyDao;
import yjk.mypage.buy.util.MyPageBuyDaoImpl;


/**
 * Servlet implementation class JoinController
 */
@WebServlet(name = "MyPageBuyController", urlPatterns = {
"/mypageBuy", "/mypageBuy2" , "/mypageBuyDetail"})
public class MyPageBuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		int lastIndex = url.lastIndexOf("/");
		String action = url.substring(lastIndex+1);
		if(action.equals("mypageBuy")) {
			request.setCharacterEncoding("utf-8");
			String mid = request.getParameter("mid");
			MyPageBuyDao mpb = new MyPageBuyDaoImpl();
			List<s_deal> las = mpb.buyselect(mid);
			request.setAttribute("las", las);
		}else if(action.equals("mypageBuy2")) {
			request.setCharacterEncoding("utf-8");
			String mid = request.getParameter("mid");
			MyPageBuyDao mpb = new MyPageBuyDaoImpl();
			List<s_deal> las = mpb.buyselect2(mid);
			request.setAttribute("las", las);
		}else if(action.equals("mypageBuyDetail")) {
			request.setCharacterEncoding("utf-8");
			int did = Integer.parseInt(request.getParameter("did"));
			MyPageBuyDao mpb = new MyPageBuyDaoImpl();
			List<s_deal_view> ls = mpb.Detailselect(did);
			request.setAttribute("ls", ls);
			request.setAttribute("did", did);
		}
		String dispatchUrl = null;
		if(action.equals("mypageBuy")) {
			dispatchUrl = "/member/yjk/view/jsp/MyPage_Buy_Select.jsp";
		}else if(action.equals("mypageBuy2")) {
			dispatchUrl = "/member/yjk/view/jsp/MyPage_Buy_Select.jsp";
		}else if(action.equals("mypageBuyDetail")) {
			dispatchUrl = "/member/yjk/view/jsp/MyPage_Buy_Detail.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(request, response);
	}
}
