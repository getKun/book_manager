package com.cduest.service.impl;

import java.util.ArrayList;
import com.cduest.dao.IFuzzyQueryDao;
import com.cduest.dao.impl.FuzzyQueryJdbc;
import com.cduest.service.IFuzzyQueryService;

/**
 * 模糊查询的service实现类
 * @author 1630720115
 *
 */
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

	//模糊查询图书
	@Override
	public ArrayList<Object> bookFuzzyQuery(String bid) {
		
		if(!bid.equals(null)&&!bid.equals("")) {
			list=dao.bookFuzzyQuery(bid);
			return list;
		}
		return null;
	}

}
