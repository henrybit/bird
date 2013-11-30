package com.joinus.server.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joinus.server.manager.user.UserManager;

/**
 * Servlet implementation class UploadContact
 */
public class UploadContact extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public UploadContact() {
    	super();
    	/**请求的参数列表*/
    	parametersName = new String[]{"uid","friend_id","phoneNo","deviceNo","name"};
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<HashMap<String, String>> parametersList = doParametersList(request);
		String json = UserManager.getInstance().uploadContactList(parametersList);
		response.getOutputStream().write(json.getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
