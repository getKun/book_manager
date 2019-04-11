package com.cduest.service;

import java.util.ArrayList;
import com.cduest.model.User;

/**
 * 查询全部已借出图书或某个用户已借出图书的service层接口
 * @author 1630720115
 *
 */
public interface IPublicQueryBookService {

	ArrayList<Object> queryAllBorrowedBook();
	
	ArrayList<Object> queryUserBorrowedBook(User user);
}
