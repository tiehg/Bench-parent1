package com.bench.Bench.web;

import com.bench.Bench.dao.S3MuserMapper;
import com.bench.bean.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("muser")
public class MuserAction {

    @Resource
    private S3MuserMapper muserMapper;

    @PostMapping("mlogin")
    public Result mlogin(@RequestBody S3Muser muser) {
        S3MuserExample mue = new S3MuserExample();
        mue.createCriteria().andMaccountEqualTo(muser.getMaccount()).andPwdEqualTo(muser.getPwd());
        List<S3Muser> list = muserMapper.selectByExample(mue);
        if (list.isEmpty()) {
            return new Result(0, "登录失败");
        } else {
            return new Result(1, "登录成功", list.get(0));
        }

    }
}
