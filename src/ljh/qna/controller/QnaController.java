package ljh.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ljh.model.page.PageGroupResult;
import ljh.qna.error.QnaError;
import ljh.qna.error.model.QnaErrorModel;
import ljh.qna.model.Qna_model;
import ljh.qna.page.sql.CountSql;
import ljh.qna.page.validate.QnaValidate;
import ljh.qna.pageservice.PageManager;
import ljh.qna.util.QnaDao;
import ljh.qna.util.QnaDaoImpl;



@WebServlet(name = "QnaController", urlPatterns = {"/qna_search","/comment_list","/qna_save","/qna_input"
		,"/qna_update","/qna_delete","/qna_action","/qna_hitup","/qna_up","/qna_list_request"})
public class QnaController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		prosess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		prosess(request, response);
	}

	private void prosess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI(); //url
		int lastIndex = url.lastIndexOf("/");  //url/
		String action = url.substring(lastIndex+1); //action
		if(action.equals("qna_input")) {


			//아무짓도 안함
		}else if(action.equals("qna_save")) {
			QnaErrorModel qnaErrorModel = new QnaErrorModel();
			//유효성 검사

			qnaErrorModel.setQtitle(request.getParameter("qtitle"));
			qnaErrorModel.setQcontent(request.getParameter("qcontent"));
			QnaValidate qnaValidate = new QnaValidate();
			QnaError qnaerror = qnaValidate.validate(qnaErrorModel);

			if(!qnaerror.isResult()) {
				Qna_model qna = new Qna_model();
				qna.setMid(request.getParameter("mid"));
				qna.setQname(request.getParameter("mname"));
				qna.setQtitle(request.getParameter("qtitle"));
				qna.setQcontent(request.getParameter("qcontent"));
				QnaDao qnadao = new QnaDaoImpl();
				qnadao.insert(qna);
			}else {
				request.setAttribute("qnaerror", qnaerror);
				request.setAttribute("qnaErrorModel", qnaErrorModel);
				action = "qna_input";
			}
		}else if(action.equals("qna_update")) {
			Qna_model qna = new Qna_model();
			qna.setQid(Integer.parseInt(request.getParameter("mid")));
			qna.setQtitle(request.getParameter("qtitle"));
			qna.setQcontent(request.getParameter("qcontent"));
			QnaDao qnadao = new QnaDaoImpl();
			qnadao.update(qna);

		}else if(action.equals("qna_delete")) {
			int qid = Integer.parseInt(request.getParameter("mid"));
			QnaDao qnadao = new QnaDaoImpl();
			qnadao.delete(qid);
		}else if(action.equals("qna_search")) {
			int requestPage = 1;
			try {
				
				if(request.getParameter("reqPage") != null) {
					requestPage = Integer.parseInt(request.getParameter("reqPage"));
				}
				

			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			QnaDao qnadao = new QnaDaoImpl();
			List<Qna_model> qnalist = qnadao.select(requestPage);
			PageManager pageManager = new PageManager(requestPage);
			PageGroupResult pageGroupResult = 
					pageManager.getPageGroupResult(CountSql.MEMO_SELECT_ALL_COUNT_SQL);


			request.setAttribute("pageGroupResult", pageGroupResult);
			request.setAttribute("qnalist", qnalist);
		}else if(action.equals("qna_action")) {
			int qid = Integer.parseInt(request.getParameter("qid"));
			String qname = request.getParameter("qname");
			QnaDao qnadao = new QnaDaoImpl();
			qnadao.updatecount(qid);
			Qna_model qna = qnadao.detail(qid);
			request.setAttribute("qna", qna);
			request.setAttribute("qname", qname);
		}

		else if(action.equals("qna_up")) {
			int qid = Integer.parseInt(request.getParameter("qid"));

			QnaDao qnadao = new QnaDaoImpl();
			Qna_model qna = qnadao.detail(qid);
			request.setAttribute("qna", qna);
			
		}



		String dispatchUrl = null;
		if(action.equals("qna_input")) {
			dispatchUrl ="/member/ljh/Qna_Writing.jsp";
		}else if(action.equals("qna_save")) {
			dispatchUrl ="qna_search";
		}else if(action.equals("qna_update")) {
			dispatchUrl = "qna_search";
		}else if(action.equals("qna_delete")) {
			dispatchUrl = "qna_search";
		}else if(action.equals("qna_search")) {
			dispatchUrl = "/member/ljh/Qna.jsp";
		}else if(action.equals("qna_action")) {
			dispatchUrl = "/member/ljh/Qna_Detail.jsp";
		}else if(action.equals("qna_up")) {
			dispatchUrl = "/member/ljh/Qna_UpdateBase.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(dispatchUrl);
		dispatcher.forward(request, response);
	}

}
