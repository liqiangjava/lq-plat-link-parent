package com.lq.plat.link.repository;

import com.lq.plat.link.account.InfoAccount;
import com.lq.plat.link.support.PlatFormRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 账户数据访问层
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/20
 */
public interface InfoAccountRepository extends PlatFormRepository<InfoAccount> {



    @Query(value = "select ia.* from info_account ia where ia.info_user_id = ?1",nativeQuery=true)
    public InfoAccount findByUserId( Long userId);


}
