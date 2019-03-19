package com.cduest.dao;

import com.cduest.model.User;

/**
 * ÓÃ»§µÇÂ¼×¢²ádao²ã
 * @author 1630720115
 *
 */
public interface IUserLoginAndRegister {

	boolean login(User user);
	boolean register(User user);
	boolean registerJudge(User user);
	
}
