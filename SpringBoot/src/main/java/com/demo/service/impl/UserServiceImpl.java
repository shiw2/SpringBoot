package com.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.mapper.UserMapper;
import com.demo.model.TbUser;
import com.demo.service.UserService;
import com.demo.vo.UserReq;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserMapper userMapper;

	@Override
	public void queryUserPager(int pageNO, int size) {
		// TODO Auto-generated method stub

	}

	@Override
	public void queryUserPager_1(int pageNO, int size) {
		// TODO Auto-generated method stub

	}

	@Override
	public int queryUserCount() {
		// TODO Auto-generated method stub
		return userMapper.getAll().size();
	}

	@Override
	public int queryUserCountPageNO(int size, int pageNO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TbUser queryUserById(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 赋值变量返回
	 * 
	 * @Override public String insertUser(UserReq userReq) { // TODO Auto-generated
	 *           method stub TbUser user = new TbUser();
	 * 
	 *           user.setUser_name(userReq.getUserName());
	 *           user.setUser_sex(userReq.getUserSex());
	 *           user.setUser_birthday(userReq.getUserBirthday());
	 *           user.setUser_email(userReq.getUserEmail()); String result = "One
	 *           user has been added in our database! Username: " +
	 *           user.getUser_name() + "; Gender: " + user.getUser_sex() + "; Date
	 *           of Birth: " + user.getUser_birthday() + "; Email: " +
	 *           user.getUser_email(); userMapper.insert(user); return result; }
	 */
	/**
	 * Map储存结果返回
	 * 
	 * @Override public Map<String, String> insertUser(UserReq userReq) { TbUser
	 *           user = new TbUser();
	 * 
	 *           user.setUser_name(userReq.getUserName());
	 *           user.setUser_sex(userReq.getUserSex());
	 *           user.setUser_birthday(userReq.getUserBirthday());
	 *           user.setUser_email(userReq.getUserEmail());
	 * 
	 *           userMapper.insert(user);
	 * 
	 *           Map<String, String> result = new HashMap<>(); result.put("Username:
	 *           ", user.getUser_name()); result.put("Gender: ",
	 *           user.getUser_sex()); result.put("Date of Birth: ",
	 *           user.getUser_birthday()); result.put("Email: ",
	 *           user.getUser_email());
	 * 
	 *           return result; }
	 */
	/**
	 * 存在Java Bean中
	 * 
	 */
	
	@Override
	public UserReq insertUser(UserReq userReq) {
		TbUser user = new TbUser();
		user.setUser_name(userReq.getUserName());
		user.setUser_sex(userReq.getUserSex());
		user.setUser_birthday(userReq.getUserBirthday());
		user.setUser_email(userReq.getUserEmail());
		UserReq result = new UserReq(user.getUser_name(), user.getUser_sex(), user.getUser_birthday(),
				user.getUser_email());
		return result;

	}

	@Override
	public int updateUser(TbUser user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserById(int user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUsers(int[] userIds) {
		// TODO Auto-generated method stub
		return 0;
	}

}
