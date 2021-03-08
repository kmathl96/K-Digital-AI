package com.controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/fileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("file_name");
		String savePath = "upload";
		ServletContext context = request.getServletContext();
		String sDownloadPath = context.getRealPath(savePath);
		String sFilePath = sDownloadPath + "\\" + fileName;
		
		byte b[] = new byte[4096];
		
		FileInputStream in = new FileInputStream(sFilePath);
		
		String sMimeType = getServletContext().getMimeType(sFilePath);
		System.out.println("sMimeType>>>" + sMimeType);
		
		if (sMimeType==null)
			// octet-stream : 8비트로 된 일련의 데이터; 지정되지 않은 파일 형식을 의미
			sMimeType = "application/octet-stream";
			
		response.setContentType(sMimeType);
		
		// 한글 업로드 => 한글 파일명이 깨지는 것을 방지
		String sEncoding = new String(fileName.getBytes("utf-8"), "8859_1");
		
		response.setHeader("Content-Disposision", "attachment; filename= " + sEncoding);
		
		ServletOutputStream out2 = response.getOutputStream();
		int numRead;
		
		// 바이트 배열 b의 0~numRead를 브라우저로 출력
		while ((numRead = in.read(b, 0, b.length)) != -1) {
			out2.write(b, 0, numRead);
		}
		out2.flush();
		out2.close();
		in.close();
	}

}
