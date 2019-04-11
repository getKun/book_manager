package com.cduest.dao;

import com.cduest.model.User;

/**
 * ÓÃ»§µÇÂ¼×¢²ádao²ã
 * @author 1630720115
 *
 */
public interface IUserLoginAndRegisterDao {

	boolean login(User user);
	boolean register(User user);
	boolean registerJudge(User user);
	
}
