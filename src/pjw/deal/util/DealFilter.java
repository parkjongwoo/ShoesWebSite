package pjw.deal.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pjw.basket.dao.basket.BasketDao;
import pjw.basket.dao.basket.BasketDaoImpl;
import pjw.basket.model.BasketListItem;
import yjk.join.model.Member;

/**
 * Servlet Filter implementation class DealFilter
 */
@WebFilter("/product_buy/*")
public class DealFilter implements Filter {

    /**
     * Default constructor. 
     */
    public DealFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");		
		
		String pids = request.getParameter("pid");
		String quantitys = request.getParameter("quantity");
		int pid=-1;
		int quantity=-1;
		
		try {
			pid = Integer.parseInt(pids);
			quantity = Integer.parseInt(quantitys);
		} catch (NumberFormatException e) {
			System.out.println("error:"+e.getMessage());
		}
		
		Member m = (Member)session.getAttribute("member");
		String mid = null;
		if(m!=null) {
			mid = m.getMid();
		}
		List<BasketListItem> sessionlist = (List<BasketListItem>)session.getAttribute("basketList");
		
		
		if(pid > 0 && quantity > 0 && mid != null) {//상품상세의 바로구매-- 쿼리 날려 데이터를 만들자
			BasketDao basketDao = new BasketDaoImpl();
			List<BasketListItem> dealList = basketDao.selectByPid(mid, quantity, pid);
			session.setAttribute("basketList", dealList);
			
		}else if(sessionlist != null && sessionlist.size()>0) {//세션 장바구니
			
		}else {//표시할 수 있는 상품이 없음. 응답 중단
			RequestDispatcher dispatcher = req.getRequestDispatcher("dealError");
			dispatcher.forward(request, response);
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
