package com.bench.Bench.remote;

import com.bench.bean.Result;
import com.bench.bean.S3Muser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("bback")
public interface IMuserAction {

    //管理员登录接口
    @PostMapping("muser/mlogin")
    Result mlogin(@RequestBody S3Muser muser);
}
