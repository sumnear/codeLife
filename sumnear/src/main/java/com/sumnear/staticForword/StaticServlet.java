//package com.sumnear.staticForword;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.catalina.servlets.DefaultServlet;
//
//@WebServlet(name = "view", urlPatterns = "/view/*")
//public class StaticServlet extends DefaultServlet {
//	private static String basepath = "E:/dcs/sampledoc/output/";
//
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws IOException {
//		System.out.println("view");
//		String relationPath = request.getRequestURI();
//		relationPath = relationPath.substring(relationPath.indexOf("/staticForword/view") + 19, relationPath.length());
//		String absolutePath = basepath + relationPath;
//		File file = new File(absolutePath); // 打开文件
//		if (!file.exists()) {
//			response.setHeader("Content-type", "text/html;charset=UTF-8");
//			response.setCharacterEncoding("UTF-8");
//			PrintWriter pw = response.getWriter();
//			pw.write("文档已经被删除");
//			pw.close();
//			return;
//		}
//		String contentType = getServletContext().getMimeType(file.getName());
//		response.setHeader("Content-type", contentType);
//		response.setCharacterEncoding("UTF-8");
//		OutputStream os = response.getOutputStream();
//		BufferedOutputStream bos = new BufferedOutputStream(os);
//		byte[] buffer = new byte[4096];
//		int len = 0;
//		FileInputStream fis = new FileInputStream(file);
//		// OutputStream os = response.getOutputStream(); // 输出流
//		try {
//			while ((len = fis.read(buffer)) > 0) {
//				bos.write(buffer, 0, len);
//			}
//		} finally {
//			bos.flush();
//			bos.close();
//			fis.close();
//		}
//		// file.delete();
//	}
//
//	/*
//	 * @Override
//	 * protected void service(HttpServletRequest request, HttpServletResponse response)
//	 * throws ServletException, IOException {
//	 * // getServletContext().getMimeType(resource.getName());
//	 * getServletContext().
//	 * serveResource(request, response, true, fileEncoding);
//	 * }
//	 * @Override
//	 * public String getRelativePath(HttpServletRequest request) {
//	 * String path = "E:/dcs/";
//	 * }
//	 */
//}
