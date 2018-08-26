package kjs.S_Product_Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kjs.S_ProductInsertModel.InsertModel;
import kjs.S_ProductInsertModel.ValueModel;
import kjs.S_Product_InsertDao.InsertImpl;
import kjs.S_Product_InsertDao.InsertInterface;
import kjs.S_Product_PageModel.PageGroupResult;
import kjs.S_Product_util.CountSql;
import kjs.S_Product_util.PageManager;


@WebServlet(urlPatterns= {"/admin_productForm","/admin_productinsert","/admin_productList"})
public class InsertController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Process(request,response);
	}

	private void Process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI();
		
		int lastIndex=uri.lastIndexOf("/");
		
		String action=uri.substring(lastIndex+1);
		
		if(action.equals("admin_productinsert")) {
			
			request.setCharacterEncoding("utf-8");
			
			String pname=request.getParameter("pname");
			String pimg_url=request.getParameter("pimg_url");
//			System.out.println("img_url:"+pimg_url);
			String poption=request.getParameter("poption");
			String phome=request.getParameter("phome");
			int pdcharge=Integer.parseInt(request.getParameter("pdcharge"));
			int pprice=Integer.parseInt(request.getParameter("pprice"));
			String pdescription=request.getParameter("pdescription");
			String ppost_yn=request.getParameter("ppost_yn");
			int cid=Integer.parseInt(request.getParameter("cid"));
			InsertImpl impl=new InsertImpl();
			InsertModel insertmodel=new InsertModel();
			
		
			
			insertmodel.setPname(pname);
			insertmodel.setPimg_url(pimg_url);
			insertmodel.setPoption(poption);
			insertmodel.setPhome(phome);
			insertmodel.setPdcharge(pdcharge);
			insertmodel.setPprice(pprice);
			insertmodel.setPdescription(pdescription);
			insertmodel.setPpost_yn(ppost_yn);
			insertmodel.setCid(cid);
			
			impl.Insert(insertmodel);
			
			
			
			
		}
		else if(action.equals("admin_productList")) {
			
			
			int requestPage=1;
			
			try {
				requestPage= Integer.parseInt(request.getParameter("reqPage"));
			} catch (NumberFormatException e) {
				System.out.println("error:"+e.getMessage());
			}
			
			request.setCharacterEncoding("utf-8");
			InsertInterface insertif= new InsertImpl();
			List<InsertModel> lm =insertif.selectAll(requestPage);
			
			
			PageManager pageManager = new PageManager(requestPage);
			PageGroupResult pageGroupResult = pageManager.getPageGroupResult(CountSql.MEMO_SELECT_ALL_COUNT_SQL);
			request.setAttribute("pageGroupResult", pageGroupResult);
			request.setAttribute("lm", lm);
			
		}else if(action.equals("admin_productForm")) {
			request.setCharacterEncoding("utf-8");
			InsertInterface insertif= new InsertImpl();
			List<ValueModel> vm =insertif.select();
			
			request.setAttribute("vm", vm);
			
		}
	
		
		String dispatch=null;
		
		if(action.equals("admin_productinsert")) {
			dispatch="admin_productList";
		}
		else if(action.equals("admin_productList")) {
			dispatch="/member/kjs/view/jsp/S_Product_List2.jsp";
			
		}else if(action.equals("admin_productForm")) {
			
			dispatch="/member/kjs/view/jsp/S_Product_Form.jsp";
			
			
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(dispatch);
		dispatcher.forward(request, response);
		
	}

}
