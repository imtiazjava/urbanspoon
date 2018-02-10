package com.ts.us.controller;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.ts.UploadPro;
import com.ts.dao.UploadDAO;

@WebServlet("/urbanspoon")
public class UrbanSpoonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UrbanSpoonController() {
		System.out.println("**UrbanSpoonController object is created...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println(request.getParameter("uname"));
		System.out.println(request.getParameter("rfile"));
		String uname = "";
		String imageName = "";
		String labelName = "";

		if (isMultipart) {
			// step1:
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			// step2:
			try {
				List<FileItem> listFileItem = servletFileUpload.parseRequest(request);
				for (FileItem fi : listFileItem) {
					System.out.println(fi);
					if (fi.getFieldName().equals("uname")) {
						System.out.println(fi.getString() + "<===========");
						uname = fi.getString();
					}
					if (fi.getFieldName().equals("rfile")) {
						imageName = fi.getString();
						labelName = fi.getName();
						String path = "D:/MyImages/" + labelName;
						File f = new File(path);
						if (!f.exists()) {
							fi.write(f);
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		UploadPro upro = new UploadPro();
		upro.setName(uname);
		upro.setImageName(labelName);
		System.out.println("GetName:" + upro.getName());
		System.out.println("GetImageName:" + upro.getImageName());
		UploadDAO udo = new UploadDAO();
		udo.store(upro);

	}

}
