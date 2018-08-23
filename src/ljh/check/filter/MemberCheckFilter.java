package ljh.check.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;




/**
 * Servlet Filter implementation class MemberCheckFilter
 */
@WebFilter(filterName="/MemberCheckFilter", urlPatterns="/private/*")
public class MemberCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MemberCheckFilter() {
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
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String a = "qq@qq";
		session.setAttribute("ID", a);
		chain.doFilter(request, response);
		String id = (String) session.getAttribute("ID");

		
//		boolean login = false;
//		if(session != null) {
//			if(session.getAttribute("mid") !=null) {
//				login = true;
//			}
//		}
//		if(login) {
//			chain.doFilter(request, response);
//		}else {
//			((HttpServletResponse)response).sendRedirect("/Register/error");
//		}	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
