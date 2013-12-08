package com.joinus.server.servlet.plazaActivity;

import com.joinus.server.manager.activity.PlazaActivityManager;
import com.joinus.server.servlet.BaseServlet;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetPlazaActivity
 */
public class GetPlazaActivity extends BaseServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetPlazaActivity() {
        super();
        parametersName = new String[]{"id","name","tag","content","createUserId","joinUsersId","latitude","longitude","address","startTime","headPic","bigPic"};
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> parameters = doParameters(request);
		String json = PlazaActivityManager.getInstance().createPlazaActivity(parameters);
		response.getOutputStream().write(json.getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
