package com.mes.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.utility.Action;
import com.mes.utility.ActionForward;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, Action> actionMap;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		actionMap=new HashMap<String, Action>();
		
		String configFile=config.getInitParameter("configFile");
		String configFilePath=config.getServletContext().getRealPath(configFile);
		Properties properties=new Properties();
		
		try {
			FileInputStream fis=new FileInputStream(configFilePath);
			properties.load(fis);
			fis.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		for(Object key:properties.keySet()) {
			String actionCommand=(String)key;
			String actionClass=(String)properties.get(key);
			try {
				Action actionInstance=(Action)Class.forName(actionClass).newInstance();
				actionMap.put(actionCommand, actionInstance);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		System.out.println("command = "+command);
				
		Action action=actionMap.get(command);
		if(action==null) {
			action=actionMap.get("/error.do");
		}
		
		ActionForward actionForward;
		try {
			actionForward = action.execute(request, response);
			if(actionForward.isRedirect()) {
				request.getRequestDispatcher
				(actionForward.getPath()).forward(request, response);
			} else {
				response.sendRedirect(actionForward.getPath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
