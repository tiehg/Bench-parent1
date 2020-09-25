package com.bench.Bench.dao;

import com.bench.bean.S3Muser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuserDao extends JpaRepository<S3Muser,Integer> {

    S3Muser findByMaccount(String Maccount);

    S3Muser findByMaccountAndPwd(String Maccount , String pwd);

}
