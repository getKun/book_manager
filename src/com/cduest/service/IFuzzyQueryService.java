package com.cduest.service;

import java.util.ArrayList;


/**
 * 模糊查询service层接口
 * @author 1630720115
 *
 */
public interface IFuzzyQueryService {

	ArrayList<Object> userFuzzyQuery(String uid);
	
	ArrayList<Object> bookFuzzyQuery(String bid);
}
