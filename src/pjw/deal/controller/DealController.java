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
import pjw.deal.dao.deal.DealDao;
import pjw.deal.dao.deal.DealDaoImpl;
import pjw.deal.model.Deal;
import yjk.join.model.Member;

/**
 * Servlet implementation class ProductController
 */
@WebServlet(name = "DealController", 
			urlPatterns = {					
					"/product_buy",//구매화면 노출
					"/addressPopup",//주소검색창호출
					"/dealError",//비정상 거래화면 접근
					"/addressRecentJson",//최근 거래 주소 목록
					"/dealInsert" })//구매요청 처리
public class DealController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DealDao dao = new DealDaoImpl();

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
			Deal deal = new Deal();
			List<BasketListItem> orderList = (List<BasketListItem>)request.getSession().getAttribute("orderList");
			Member member = (Member)request.getSession().getAttribute("member");
			if(member!=null)
				deal.setMid(member.getMid());
			deal.setDtitle(getDealTitle(orderList));
			deal.setDdcharge(getddcharge(orderList));
			deal.setDdstate("결제완료");
			deal.setDdname(request.getParameter("name"));
			deal.setDdphone(request.getParameter("pnum"));
			deal.setDdphone2(request.getParameter("pnum2"));
			deal.setDdzipcode(request.getParameter("zipcode"));
			deal.setDdadress(request.getParameter("addr"));
			deal.setDda_detail(request.getParameter("addr_detail"));
			deal.setDdmsg(request.getParameter("dmsg"));
			deal.setDdmethod(request.getParameter("dmethod"));
			if("계좌이체".equals(deal.getDdmethod())) {
				deal.setDdcash_num(request.getParameter("ddcash_num"));
				deal.setDdcash_use(request.getParameter("ddcash_use"));
				deal.setDdcash_request(request.getParameter("ddcash_request"));
			}else {
				deal.setDdcard(request.getParameter("ddcard"));
				deal.setDdinstallment(Integer.parseInt(request.getParameter("installment")));
			}			
			deal.setDealProducts(orderList);
			deal.setDtotal(getTotal(orderList));
			
			boolean result = dao.insert(deal);
			if(result) {
				try {
					BasketDao bdao = new BasketDaoImpl();
					bdao.clearBasketByMid(member.getMid());
				} catch (NullPointerException e) {
					System.out.println("거래후 장바구니 비우기 실패."+e.getMessage());
				}
			}
			request.setAttribute("result", result);
			
		} else if (action.equals("addressPopup")) {
			
		} else if (action.equals("addressRecentJson")) {
			Member member = (Member)request.getSession().getAttribute("member");
			List<Deal> list = null;
			if(member!=null) {
				list = dao.selectRecentDeal(member.getMid());
				request.setAttribute("addressRecentList", list);
			}
			request.setAttribute("result", list != null);			
		}

		String requestUrl = null;

		if (action.equals("product_buy")) {
			requestUrl = "/member/pjw/view/deal/jsp/dealPage.jsp";	
		} else if (action.equals("dealError")) {			
			requestUrl = "/member/pjw/view/deal/jsp/dealErrorPage.jsp";	
		} else if (action.equals("dealInsert")) {
			boolean result = (boolean)request.getAttribute("result");
			response.setHeader("Cache-Control", "no-chache");
			response.setHeader("Expires", "Sat, 01 Jan 1970 22:00:00 GMT");
			response.setHeader("Pragma", "no-cache");
			if(result) {				
				requestUrl = "/member/pjw/view/deal/jsp/dealcompletePage.jsp";				
			}else {
				requestUrl = "/member/pjw/view/deal/jsp/dealErrorPage.jsp";	
			}
		} else if (action.equals("addressPopup")) {
			requestUrl = "/member/pjw/view/deal/jsp/addressPopupPage.jsp";
		} else if (action.equals("addressRecentJson")) {
			requestUrl = "/member/pjw/view/deal/jsp/addressRecentJson.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(requestUrl);
		dispatcher.forward(request, response);
	}

	

	private int getTotal(List<BasketListItem> orderList) {
		int result = 0;
		for(BasketListItem i : orderList) {
			result += (i.getBquantity()*i.getPprice());
		}
		return result;
	}



	private int getddcharge(List<BasketListItem> orderList) {
		int result=0;
		for(BasketListItem i : orderList) {
			if(result<i.getPdcharge()) {
				result = i.getPdcharge();
			}
		}
		return result;
	}



	private String getDealTitle(List<BasketListItem> orderList) {
		StringBuffer result = new StringBuffer();
		if(orderList.size()<=1) {
			result.append(orderList.get(0).getPname());
		}else {
			result.append(orderList.get(0).getPname()).append(" 외 ").append(orderList.size()-1)
			.append("개 품목");
		}
		return result.toString();
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
