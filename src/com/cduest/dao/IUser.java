package com.cduest.dao;

import com.cduest.model.User;

public interface IUser {

	boolean login(User user);
	boolean register(User user);
	boolean registerJudge(User user);
	
}
