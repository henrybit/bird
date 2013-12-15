package com.joinus.server.servlet.upload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadImage
 */
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**文件存储系统路径*/
	private static String uploadPath = "/develop/server/images/";
	/**文件存储系统路径File对象*/
	private static File uploadPathFile = new File(uploadPath);
	/**临时文件存储系统路径*/
	private static String tempPath = "/develop/server/images/temp/";
	/**临时文件存储系统路径File对象*/
	private static File tempPathFile = new File(tempPath);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImage() {
        super();
    }
    
    

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		super.init();
	}



	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		uploadPath = config.getServletContext().getInitParameter("imagePath");
		uploadPathFile = new File(uploadPath);
		
		tempPath = config.getServletContext().getInitParameter("imageTempPath");
		tempPathFile = new File(tempPath);
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(4096);
			factory.setRepository(tempPathFile);
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB
			List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
			Iterator<FileItem> i = items.iterator();
			while (i.hasNext()) {
			    FileItem fi = (FileItem) i.next();
			    String fileName = fi.getName();
			    if (fileName != null) {
			     File fullFile = new File(fi.getName());
			     File savedFile = new File(uploadPath, fullFile.getName());
			     fi.write(savedFile);
			    }
			 }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
