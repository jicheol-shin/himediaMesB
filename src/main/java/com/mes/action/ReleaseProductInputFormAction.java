package com.mes.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.utility.Action;
import com.mes.utility.ActionForward;

public class ReleaseProductInputFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("/releaseProduct/releaseProductInput.jsp");
		return actionForward;
	}

}
