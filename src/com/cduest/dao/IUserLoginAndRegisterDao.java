package com.cduest.dao;

import com.cduest.model.User;

/**
 * �û���¼ע��dao��
 * @author 1630720115
 *
 */
public interface IUserLoginAndRegisterDao {

	boolean login(User user);
	boolean register(User user);
	boolean registerJudge(User user);
	
}
