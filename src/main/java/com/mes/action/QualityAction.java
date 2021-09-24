package com.mes.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.QualityService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.Quality;

public class QualityAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Quality> qualityList = new ArrayList<Quality>();
		QualityService qualityService = new QualityService();
		
		qualityList = qualityService.getQualityList();
		
		req.setAttribute("qualityList", qualityList);
		ActionForward forward = new ActionForward();
		forward.setPath("/quality/qulity.jsp");
		
		return forward;
	}

}
