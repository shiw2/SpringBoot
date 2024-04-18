package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.model.TbUser;
import com.demo.service.UserService;
import com.demo.vo.UserReq;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService serv;

	/*
	 * 用户列表与分页Action
	 */
	@PostMapping("/list")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> list(@RequestParam(required = false, defaultValue = "1") int pageNO) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("usercount", serv.queryUserCount());

		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

	/*
	 * 用户添加
	 */
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> add(@RequestBody(required = true) UserReq userReq) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("person", serv.insertUser(userReq));
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

	/**
	 * 添加用户保存
	 * 
	 * @param model
	 * @param entity
	 * @return
	 */
	@RequestMapping("/save")
	public String save(Model model, @ModelAttribute("user") @Valid TbUser user) {

		return "redirect:/user/list";
	}

	/**
	 * 编辑用户
	 * 
	 * @param model
	 * @param user_id
	 * @return
	 */
	@RequestMapping("/edit/{user_id}")
	public String edit(Model model, @PathVariable int user_id) {

		model.addAttribute("user", serv.queryUserById(user_id));
		return "user/edit";
	}

	/**
	 * 修改用户并保存
	 * 
	 * @param model
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("/editSave")
	public String editSave(Model model, @ModelAttribute("user") @Valid TbUser user) {
		serv.updateUser(user);
		return "redirect:/user/list";
	}

	/**
	 * 根据用户id删除用户
	 * 
	 * @param model
	 * @param user_id
	 * @param pageNO
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("/deleteUserById/{user_id}")
	public String deleteUserById(Model model, @PathVariable int user_id,
			@RequestParam(required = false, defaultValue = "1") int pageNO, RedirectAttributes redirectAttributes) {

		if (serv.deleteUserById(user_id) > 0) {
			redirectAttributes.addFlashAttribute("message", "删除成功！");
		} else {
			redirectAttributes.addFlashAttribute("message", "删除失败！");
		}
		return "redirect:/user/list?pageNO=" + pageNO;

	}

	/**
	 * 删除多个用户
	 * 
	 * @param model
	 * @param userIds
	 * @param pageNO
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("/deleteUsers")
	public String deleteUsers(Model model, @RequestParam int[] userId,
			@RequestParam(required = false, defaultValue = "1") int pageNO, RedirectAttributes redirectAttributes) {

		if (serv.deleteUsers(userId) > 0) {
			redirectAttributes.addFlashAttribute("message", "删除成功！");
		} else {
			redirectAttributes.addFlashAttribute("message", "删除失败！");
		}
		return "redirect:/user/list?pageNO=" + pageNO;
	}

}
