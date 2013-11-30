package com.joinus.server.servlet.activity;

import com.joinus.server.manager.activity.ActivityManager;
import com.joinus.server.servlet.BaseServlet;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetMeetings
 */
public class GetMeetings extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public GetMeetings() {
    	super();
    	/**请求的参数列表*/
    	parametersName = new String[]{"uid","fields","update_time"};
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, String> parameters = doParameters(request);
		String json = ActivityManager.getInstance().getMeeting(parameters);
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
