package com.mes.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Action {
	
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception;
	
}
