package com.demo.service;

import com.demo.model.TbUser;
import com.demo.vo.UserReq;

public interface UserService {
	/**
	 * 分页
	 * 
	 * @param pageNO
	 * @param size
	 * @return
	 */
	public void queryUserPager(int pageNO, int size);

	public void queryUserPager_1(int pageNO, int size);

	/**
	 * 查询用户总数
	 * 
	 * @return
	 */
	public int queryUserCount();

	/** public int queryUserCountCurrentPageNO(int pageNO); */
	public int queryUserCountPageNO(int size, int pageNO);

	/**
	 * 根据用户id查询用户
	 * 
	 * @param userid
	 * @return
	 */
	public TbUser queryUserById(int userid);

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	public UserReq insertUser(UserReq userReq);

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	public int updateUser(TbUser user);

	/**
	 * 根据用户id删除用户
	 * 
	 * @param user_id
	 * @return
	 */
	public int deleteUserById(int user_id);

	/**
	 * 删除多个用户
	 * 
	 * @param userIds
	 * @return
	 */
	public int deleteUsers(int[] userIds);
}
