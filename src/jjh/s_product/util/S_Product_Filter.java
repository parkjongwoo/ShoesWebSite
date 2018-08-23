package jjh.s_product.util;

import java.io.IOException;
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

@WebFilter(filterName = "/s_productFilter", urlPatterns = { "/s_p_qna_form/*", "/product_buy/*", "/product_cart/*" })
public class S_Product_Filter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		boolean login = false;

		req.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		
		String requestedurl = null;
		String requestedqueryString = null;
		if (request instanceof HttpServletRequest) {
			requestedurl = ((HttpServletRequest) request).getRequestURL().toString();
			requestedqueryString = ((HttpServletRequest) request).getQueryString();
		}

		if (session != null) {
			if (session.getAttribute("member") != null) {
				login = true;

			}
		}
		if (login) {
			chain.doFilter(request, response);
		} else {

			String dispatchUrl = null;
			String url = requestedurl + (requestedqueryString==null?"":"?"+requestedqueryString);
			HttpServletResponse resp = (HttpServletResponse) response;
			System.out.println("filter url:"+url);
			try {
				if (action.equals("s_p_qna_form")) {
					int pid = Integer.parseInt(req.getParameter("pid"));
					url = "product_page?pid=" + pid;
					session.setAttribute("pid", pid);
				} else if (action.equals("product_buy")) {
					int pid = Integer.parseInt(req.getParameter("pid"));
					url = "product_page?pid=" + pid;
					session.setAttribute("pid", pid);
				} else if (action.equals("product_cart")) {
					int pid = Integer.parseInt(req.getParameter("pid"));
					url = "product_page?pid=" + pid;
					session.setAttribute("pid", pid);

				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("lastURL", url);
			RequestDispatcher rd = request.getRequestDispatcher("start");
			rd.forward(request, response);

		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
