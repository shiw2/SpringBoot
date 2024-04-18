package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.demo.model.TbUser;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<TbUser> {

	/**
	 * 查询所有用户
	 */
	@Select("select * from tb_user")
	List<TbUser> getAll();

}
