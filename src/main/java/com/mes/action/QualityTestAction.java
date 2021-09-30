package com.mes.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mes.service.QualityTestService;
import com.mes.utility.Action;
import com.mes.utility.ActionForward;
import com.mes.vo.ProductionLine;

public class QualityTestAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ArrayList<ProductionLine> qualityTestList = new ArrayList<ProductionLine>();
		QualityTestService qualityService = new QualityTestService();
		
		qualityTestList = qualityService.getQualityList();
		
		req.setAttribute("qualityTestList", qualityTestList);
		ActionForward forward = new ActionForward();
		forward.setPath("/quality/qulity.jsp");
		
		return forward;
	}

}
