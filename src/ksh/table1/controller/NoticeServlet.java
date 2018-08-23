package ksh.table1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ksh.table1.dao.noticeDAO.implDAO;
import ksh.table1.model.page.PageGroupResult;
import ksh.table1.service.PageManager;
import ksh.table1.sql.CountSql;
import ksh.table1.vo.NoticeVO;


/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet(urlPatterns= {
		"/NoticeSelectAll",
		"/NoticeInsert",
		"/NoticeServlet",
		"/NoticeSelect",
		"/NoticeUpdate",
		"/NoticeDelete",
		"/NoticeUpdatePage", 
		"/NoticeSelectDay",
		"/NoticeCountNhit",
		"/NoticeInsertGO",
		"/NoticeUpdateGO"
		})
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int requestPage = 1;
    public NoticeServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			process(request, response);
		} catch (Exception e) { e.printStackTrace(); }
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex+1);
		
		
		if(action.equals("NoticeCountNhit")) {
			int idNhit = Integer.parseInt(request.getParameter("id"));
			implDAO impl = new implDAO();
			idNhit = impl.countNhit(idNhit);
			
			request.setAttribute("nhit", idNhit);
			
		}  if(action.equals("NoticeSelectAll")) {
			
			if(request.getParameter("reqPage") != null) { requestPage= Integer.parseInt(request.getParameter("reqPage")); }
			implDAO impl = new implDAO();
			List<NoticeVO> list = impl.select_page(requestPage);
			PageManager pageManager = new PageManager(requestPage);
			PageGroupResult pageGroupResult = pageManager.getPageGroupResult(CountSql.MEMO_SELECT_ALL_COUNT_SQL);
			request.setAttribute("list", list);
			request.setAttribute("pageGroupResult", pageGroupResult);
			
		} else if(action.equals("NoticeInsert")) {
			
			boolean onOff = false;
			
			implDAO impl = new implDAO();
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setMid(request.getParameter("mid"));
			noticeVO.setNcontent(request.getParameter("ncontent"));
			noticeVO.setNtitle(request.getParameter("ntitle"));
			
			onOff = impl.insert(noticeVO);
			
			if(onOff) { request.setAttribute("message",  "저장 잘됨");
			List<NoticeVO> list = impl.select_page(requestPage);
			PageManager pageManager = new PageManager(requestPage);
			PageGroupResult pageGroupResult = pageManager.getPageGroupResult(CountSql.MEMO_SELECT_ALL_COUNT_SQL);
			request.setAttribute("list", list);
			request.setAttribute("pageGroupResult", pageGroupResult);
			
			}else if (action.equals("")) {
				
			}
			
		}else if(action.equals("NoticeUpdate")) {
			boolean onOff = false;
			
			implDAO impl = new implDAO();
			NoticeVO noticeVO = new NoticeVO();
			
			noticeVO.setNid(Integer.parseInt(request.getParameter("nid")));
			noticeVO.setMid(request.getParameter("mid"));
			noticeVO.setNcontent(request.getParameter("ncontent"));
			noticeVO.setNtitle(request.getParameter("ntitle"));
			
			System.out.println(request.getParameter("nid"));
			System.out.println(request.getParameter("mid"));
			System.out.println(request.getParameter("ncontent"));
			System.out.println(request.getParameter("ntitle"));
			
			onOff = impl.update(noticeVO);
			System.out.println(onOff);
			
			if(onOff) { request.setAttribute("message",  "수정 잘됨");
			List<NoticeVO> list = impl.select_page(requestPage);
			PageManager pageManager = new PageManager(requestPage);
			PageGroupResult pageGroupResult = pageManager.getPageGroupResult(CountSql.MEMO_SELECT_ALL_COUNT_SQL);
			request.setAttribute("list", list);
			request.setAttribute("pageGroupResult", pageGroupResult);
			}
		} else if(action.equals("NoticeDelete")) {
			
			boolean onOff = false;
			
			implDAO impl = new implDAO();
			NoticeVO noticeVO = new NoticeVO();
			noticeVO.setMid(request.getParameter("mid"));
			noticeVO.setNid(Integer.parseInt(request.getParameter("nid")));
			
			onOff = impl.delete(noticeVO);
			
			if(onOff) { request.setAttribute("message",  "삭제 잘됨");
			List<NoticeVO> list = impl.select_page(requestPage);
			PageManager pageManager = new PageManager(requestPage);
			PageGroupResult pageGroupResult = pageManager.getPageGroupResult(CountSql.MEMO_SELECT_ALL_COUNT_SQL);
			request.setAttribute("list", list);
			request.setAttribute("pageGroupResult", pageGroupResult);
			}
		} 
		
		String rdURL = null;
		 if(action.equals("NoticeSelectAll")) {
				
			 rdURL = "member/ksh/view/jsp/noticeList2.jsp";
		} else if(action.equals("NoticeInsert")) {
			
		 rdURL = "member/ksh/view/jsp/noticeList2.jsp";
		} else if(action.equals("NoticeInsertGO")) {
			request.setAttribute("mid",request.getParameter("mid"));
			request.setAttribute("nid",request.getParameter("nid"));
		 rdURL = "member/ksh/view/jsp/insertForm.jsp";
		}else if(action.equals("NoticeUpdate")) {
			
			rdURL = "member/ksh/view/jsp/noticeList2.jsp";
		}else if(action.equals("NoticeDelete")) {
			
			rdURL = "member/ksh/view/jsp/noticeList2.jsp";
		}else if(action.equals("NoticeCountNhit")) {
			
		 rdURL = "member/ksh/view/jsp/result.jsp";
		}
		 
		 
		RequestDispatcher rd = request.getRequestDispatcher(rdURL);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		System.out.println("do post");
		
		try {
			process(request, response);
		} catch (Exception e) { e.printStackTrace(); }
		
	}

}
