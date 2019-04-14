package com.cduest.service.impl;

import java.util.ArrayList;
import com.cduest.dao.IFuzzyQueryDao;
import com.cduest.dao.impl.FuzzyQueryJdbc;
import com.cduest.service.IFuzzyQueryService;

public class FuzzyQuerySer implements IFuzzyQueryService {

	private IFuzzyQueryDao dao=new FuzzyQueryJdbc();
	private ArrayList<Object> list=new ArrayList<Object>();
	
	//模糊查询用户
	@Override
	public ArrayList<Object> userFuzzyQuery(String uid) {
		
		if(!uid.equals(null)&&!uid.equals("")) {
			list=dao.userFuzzyQuery(uid);
			return list;
		}
		return null;
	}

	@Override
	public ArrayList<Object> bookFuzzyQuery(String bid) {
		// TODO Auto-generated method stub
		return null;
	}

}
