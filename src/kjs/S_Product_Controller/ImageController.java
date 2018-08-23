package kjs.S_Product_Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class SingleUpload
 */
@WebServlet(name = "singleUpload", urlPatterns = { "/singleUpload" })
@MultipartConfig(fileSizeThreshold=1024*1024*2,maxFileSize=1024*1024*50, maxRequestSize=1024*1024*50,location="D:\\java\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ShoesWebSite\\img") 
//file 관련 처리를 수행하는 서블릿임을 알림.
//fileSizeThreshold: 파일을 임시저장하는 사이즈 크기 제한. 지정한 값 이상 전송되면 저장이 시작된다.기본값0
//maxFileSize: 파일 최대 사이즈. 넘어가면 예외발생.기본값-1(크기제한 없음)
//maxRequestSize: 요청 최대 사이즈. 넘어가면 예외발생. 기본값-1(크기제한 없음)
//location: 파일 저장 위치. Part.write(fileName)호출시 상대경로의 경우 여기에 지정한 위치를 기준으로 저장
public class ImageController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;    
	
	private String getFileName(Part filePart) {
		String url = null;
		String ContentDispositionHead = filePart.getHeader("Content-Disposition");
		String[] elements = ContentDispositionHead.split(";");
//		filePart.getSubmittedFileName()
		for(String element:elements) {
			if(element.trim().startsWith("filename")) {
				url = element.split("=")[1].replaceAll("\"", "");
//				File file = new File(url.trim());
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				Date date = new Date();
				
				
				url = sdf.format(date)+"__"+url;
//				String fileName = sdf.format(date)+url;
//				String[] fileName_fag = url.split(".");
//				String extendsion = fileName_fag[fileName_fag.length-1];
			}
		}
		
		return url;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("파일 전송에 get방식은 지원하지 않습니다.").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Part filePart = request.getPart("file_url");
		String fileName = getFileName(filePart);
//		String url = 
		
		
		
		if(fileName != null && !fileName.isEmpty()) {
			filePart.write(
//					getServletContext().getRealPath("/WEB-INF")+"/"+fileName);
					fileName);
		}
		
		response.setContentType("text/html");
		PrintWriter w = response.getWriter();
		StringBuffer sb = new StringBuffer();
//		sb.append("<!doctype html>").append('\n')
//		.append("<html>").append('\n')
//		.append("<head><meta charset='utf-8'/><title>파일업로드결과</title></head>").append('\n')
//		.append("<body>").append('\n')
//		.append("업로드한 파일이름:"+fileName+"<br>").append('\n')
//		.append("</body>").append('\n')
//		.append("</html>").append('\n');
		
		sb.append("img/"+fileName);
		
		w.println(sb);
	}
}
