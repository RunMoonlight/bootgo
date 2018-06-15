package com.bootgo.system.controller;

import java.util.List;
import java.util.Map;

import com.bootgo.common.utils.PageUtils;
import com.bootgo.common.utils.Query;
import com.bootgo.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootgo.system.domain.UserDO;
import com.bootgo.system.service.UserService;

/**
 * 
 * 
 * @author wz
 * @email 358812885@qq.com
 * @date 2018-06-14 10:29:28
 */
 
@Controller
@RequestMapping("/system/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping()
	@RequiresPermissions("system:user:user")
	String User(){
	    return "system/user/user";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:user:user")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserDO> userList = userService.list(query);
		int total = userService.count(query);
		PageUtils pageUtils = new PageUtils(userList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:user:add")
	String add(){
	    return "system/user/add";
	}

	@GetMapping("/edit/{userId}")
	@RequiresPermissions("system:user:edit")
	String edit(@PathVariable("userId") Long userId,Model model){
		UserDO user = userService.get(userId);
		model.addAttribute("user", user);
	    return "system/user/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:user:add")
	public R save( UserDO user){
		if(userService.save(user)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:user:edit")
	public R update( UserDO user){
		userService.update(user);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:user:remove")
	public R remove( Long userId){
		if(userService.remove(userId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:user:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] userIds){
		userService.batchRemove(userIds);
		return R.ok();
	}
	
}
