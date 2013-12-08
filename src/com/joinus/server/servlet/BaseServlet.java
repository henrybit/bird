package com.joinus.server.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 基础Sevlet<br>
 * @author henrybit
 * @version 1.0
 * @since 2013-4-6
 */
public class BaseServlet extends HttpServlet {
	
	/**请求的参数列表*/
	protected static String[] parametersName = null;
	
	/**
	 * 准备该请求的参数列表<br>
	 * @param request http请求
	 * @return HashMap<String,String>-返回参数列表:key-参数名,value-参数值
	 */
	protected HashMap<String, String> doParameters(HttpServletRequest request) {
		HashMap<String, String> parameters = new HashMap<String, String>();
		try {
			for(int i=0; i<parametersName.length; i++) {
				String value = request.getParameter(parametersName[i]);
				parameters.put(parametersName[i], value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parameters;
	}
	
	/**
	 * 准备该请求参数的列表<br>
	 * @param request http请求
	 * @return List<HashMap<String, String>>-返回参数列表
	 */
	protected List<HashMap<String, String>> doParametersList(HttpServletRequest request) {
		List<HashMap<String, String>> parametersList = new ArrayList<HashMap<String, String>>();
		try {
			for(int i=0; i<parametersName.length; i++) {
				String[] values = request.getParameterValues(parametersName[i]);
				
				if(values==null || values.length<=0)
					continue;
				
				for(int j=0; j<values.length; j++) {
					if(parametersList.size() < j+1) {
						HashMap<String, String> parameters = new HashMap<String, String>();
						parametersList.add(parameters);
					}
					HashMap<String, String> parameters = parametersList.get(j);
					parameters.put(parametersName[i], values[j]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parametersList; 
	}
}
