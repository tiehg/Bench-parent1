package com.bench.Bench.web;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bench.Bench.remote.IUserAction;
import com.bench.bean.Result;
import com.bench.bean.S3User;

@Controller
public class UserAction {
	
	@Resource
	private IUserAction iua;
	@Resource
	private RedisTemplate<String,String> redis;

	// 点击用户名字跳转主页
		@RequestMapping("userindex")
		public String touserindex(Model m, @RequestParam(value = "account") String account) {
			Result res = iua.getinfo(account);
			if (res.getCode() == 1) {
				m.addAttribute("user", res.getData());
			}
			return "html/user/index";

		}

		//
		@RequestMapping("usermessage")
		public String tousermessage(Model m, @RequestParam(value = "account") String account) {
			Result res = iua.getinfo(account);
			if (res.getCode() == 1) {
				m.addAttribute("user", res.getData());
			}
			return "html/user/message";

		}
		//重新验证邮箱
		@RequestMapping("useractivate")
		public String touseractivate() {

			return "html/user/activate";

		}

		// 点击我的主页跳转页面
		@RequestMapping("userhome")
		public String touserhome(Model m, @RequestParam(value = "account") String account) {
			Result res = iua.getinfo(account);
			if (res.getCode() == 1) {
				m.addAttribute("user", res.getData());
			}
			return "html/user/home";
		}

		// 基本设置页面
		@RequestMapping("userset")
		public String touserset(Model m, @RequestParam(value = "id") Integer id) {
			Result res = iua.getid(id);
			if (res.getCode() == 1) {
				m.addAttribute("user", res.getData());
			}
			return "html/user/set";
		}

		
		// 修改邮箱，性别，地点，个性签名

		@RequestMapping("update1")
		@ResponseBody
		public Result update(@RequestParam("email")String email,@RequestParam()String account,@RequestParam()String address,
				@RequestParam("signature")String signature,@RequestParam("id")Integer uid) {
			S3User user=new S3User();
			user.setEmail(email);
			user.setAccount(account);
			user.setAddress(address);
			user.setSignature(signature);
			user.setId(uid);
			Result res=iua.update1(user);
			if(res.getCode()==1) {
				return new Result(1,"修改成功");
			}else {
				return new Result(0,"修改失败");
			}
		}
		//获取原密码
		@RequestMapping("repwd")
		@ResponseBody
		public Result checkpwd(@RequestParam("id")Integer id) {
			S3User user=new S3User();
			user.setId(id);
			Result res=iua.repwd(user);
			if(res.getCode()==1) {
				return new Result(1,"true",res.getData());
			}else {
				return new Result(1,"false");
			}
		}
		//修改新密码
		@RequestMapping("savepwd")
		@ResponseBody
		public Result savepwd(@RequestParam("id")Integer id,
				@RequestParam("pwd")String pwd,@RequestParam("repwd")String repwd) {
			if(pwd.equals(repwd)==false) {
				return new Result(0,"两次密码不一致");
			}
			S3User user=new S3User();
			user.setId(id);
			user.setPwd(pwd);
			Result res=iua.savepwd(user);
			if(res.getCode()==1) {
				return new Result(1,"修改成功");
			}else {
				return new Result(0,"修改失败");
			}
		}
		//修改头像
		@PostMapping("uploadimg")
		public String upload(@RequestParam("file") MultipartFile file,Model m) throws IllegalStateException, IOException {
			String id=redis.opsForValue().get("uid");
			S3User user=new S3User();
			user.setId(Integer.valueOf(id));
			String dispath = "E:/img/";
			String spath="/images/";
			String filename = file.getOriginalFilename();// 文件名
			file.transferTo(new File(dispath + filename));//
			user.setUhead(spath+filename);
			Result res=iua.updateimg(user);
			return touserset(m,Integer.valueOf(id));
			
		}
		//保存id  30分钟
		@RequestMapping("savesession")
		@ResponseBody
		public Result save(@RequestParam("id")Integer id) {
			System.out.println(id);
			redis.opsForValue().set("uid", String.valueOf(id),30,TimeUnit.MINUTES);
			return null;
		}
}
