package com.cduest.service;

import java.util.ArrayList;


/**
 * ģ����ѯservice��ӿ�
 * @author 1630720115
 *
 */
public interface IFuzzyQueryService {

	ArrayList<Object> userFuzzyQuery(String uid);
	
	ArrayList<Object> bookFuzzyQuery(String bid);
}
