package com.bench.Bench.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bench.bean.Result;
import com.bench.bean.S3User;

@FeignClient("buser")
public interface IUserAction {
	
	@PostMapping("user/register")
	Result register(@RequestBody S3User user);
	
	@PostMapping("user/checkaccount")
	Result checkaccount(@RequestBody S3User user);
	
	@PostMapping("user/logined")
	Result logined(@RequestBody S3User user);
	
	@PostMapping("user/getinfo")
	Result getinfo(@RequestBody String account);
	
	@PostMapping("user/getid")
	Result getid(@RequestBody Integer id);
	
	@RequestMapping("user/update1")
	Result update1(@RequestBody S3User user);
	
	@RequestMapping("user/repwd")
	Result repwd(@RequestBody S3User user);
	
	@RequestMapping("user/savepwd")
	Result savepwd(@RequestBody S3User user);
	
	@PostMapping("user/updateimg")
	Result updateimg(@RequestBody S3User user);
	
	@RequestMapping("user/infoByAccount")
	S3User infoByAccount(@RequestBody String account);
	
	

}
