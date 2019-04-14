package com.cduest.dao;

import java.util.ArrayList;



/**
 * 模糊查询的dao层接口
 * @author 1630720115
 *
 */
public interface IFuzzyQueryDao {

	ArrayList<Object> userFuzzyQuery(String uid);
	
	ArrayList<Object> bookFuzzyQuery(String bid);
}
