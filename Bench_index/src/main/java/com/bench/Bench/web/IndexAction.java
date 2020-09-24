package com.bench.Bench.web;

import java.net.HttpCookie;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.bench.Bench.remote.IMuserAction;
import com.bench.bean.S3Muser;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.aliyuncs.http.HttpRequest;
import com.bench.Bench.remote.IUserAction;
import com.bench.Bench.util.SendMail;
import com.bench.bean.Result;
import com.bench.bean.S3User;

@Controller
@SessionAttributes("loginUser")
public class IndexAction {

	@Resource
	private SendMail sm;
	@Resource
	private RedisTemplate<String, String> redis;
	@Resource
	private IUserAction iua;
	@Resource
	private IMuserAction ima;

	@RequestMapping("/")
	public String index(Model m) {
		 return "html/index";
	}

	// 从用户页面跳到主页
	@RequestMapping("index")
	public String reindex(Model m) {
		S3User user = iua.infoByAccount(redis.opsForValue().get("uname"));
		m.addAttribute("user", user);
		return "html/index";
	}

	@RequestMapping("reg")
	public String toreg() {

		return "html/user/reg";
	}

	@RequestMapping("login")
	public String tologin() {

		return "html/user/login";

	}

	@RequestMapping("tomlogin")
	public String tomlogin() {

		return "html/back/mangerlogin";

	}

	@RequestMapping("logout")
	public String logout(SessionStatus ss) {
		// SessionStatus 用于终止会话
		ss.setComplete();
		redis.delete("uid");
		redis.delete("uname");
		return "html/index";
	}

	@PostMapping("logined")
	public String tologin(@Valid S3User user, Errors errors, Model m) {
		if (errors.hasFieldErrors("account") || errors.hasFieldErrors("pwd")) {
			errors.rejectValue("account", "accountError", "账号或密码错误");
		}
		Result res = iua.logined(user);
		if (res.getCode() == 1) {
			m.addAttribute("loginUser", res.getData());
			redis.opsForValue().set("uname", user.getAccount(), 30, TimeUnit.MINUTES);
			return "html/index";
		} else {
			m.addAttribute("user", user);
			m.addAttribute("errors", errors.getFieldErrors());
			return "html/user/login";
		}
	}
	//管理员登录，暂无跳转页面，所以先跳至自己
	@PostMapping("mlogin")
	public  String mlogin(@Valid S3Muser muser, Errors errors, Model m){
		if (errors.hasFieldErrors("maccount") || errors.hasFieldErrors("pwd")) {
			errors.rejectValue("maccount", "maccountError", "账号或密码错误");
		}
		Result res = ima.mlogin(muser);
		if (res.getCode() == 1) {
			m.addAttribute("loginUser", res.getData());
			return "html/back/success";
		} else {
			m.addAttribute("muser", muser);
			m.addAttribute("errors", errors.getFieldErrors());
			return "html/back/mangerlogin";
		}
	}
	@PostMapping("register")
	public String reg(@Valid S3User user, Errors errors, Model m) {

		if (user.getRepwd().equals(user.getPwd()) == false) {
			errors.rejectValue("repwd", "repwdError", "两次密码不一致");
		}
		String scode = redis.opsForValue().get("bvcode");
		/*if (user.getVercode().isEmpty() == false) {
			if (user.getVercode().equals(scode) == false) {
				errors.rejectValue("vercode", "vcodeError", "验证码不正确");
			}
		}*/
		if (errors.hasErrors()) {
			m.addAttribute("user", user);
			m.addAttribute("errors", errors.getFieldErrors());
			return "html/user/reg";
		}
		Result re = iua.checkaccount(user);
		if (re.getCode() == 1) {
			Result res = iua.register(user);
			if (res.getCode() == 1) {
				return "html/index";
			} else {
				m.addAttribute("user", user);
				m.addAttribute("errors", errors.getFieldErrors());
				return "html/user/reg";
			}
		} else {
			errors.rejectValue("account", "accountError", "该用户名已存在");
			m.addAttribute("user", user);
			m.addAttribute("errors", errors.getFieldErrors());
			return "html/user/reg";
		}

	}

	// 发送验证码

	@RequestMapping("sendemail")
	@ResponseBody
	public Result sendVcode(@RequestParam(value = "email") String email) {
		Random r = new Random();
		int num = 1000 + r.nextInt(8999);
		sm.sendSimpleMail(email, "验证码", "你好，你的验证码为" + num + "，有效期为10分钟，请尽快处理");
		redis.opsForValue().set("bvcode", String.valueOf(num), 10, TimeUnit.MINUTES);
		return new Result(1, "验证码发送成功");

	}

}
