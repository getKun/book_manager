package com.cduest.dao;

import java.util.ArrayList;



/**
 * ģ����ѯ��dao��ӿ�
 * @author 1630720115
 *
 */
public interface IFuzzyQueryDao {

	ArrayList<Object> userFuzzyQuery(String uid);
	
	ArrayList<Object> bookFuzzyQuery(String bid);
}
