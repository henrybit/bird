package com.joinus.server.servlet.comment;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joinus.server.manager.activity.PlazaActivityManager;
import com.joinus.server.servlet.BaseServlet;

/**
 * Servlet implementation class CreatePlazaShareMessage
 */
public class CreatePlazaShareMessage extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreatePlazaShareMessage() {
        super();
        parametersName = new String[]{"id","aid","shareUid","content","content","pic","shareTime"};
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> parameters = doParameters(request);
		String json = PlazaActivityManager.getInstance().addShareMessage(parameters);
		response.getOutputStream().write(json.getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
