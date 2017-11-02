package com.lq.plat.link.repository;

import com.lq.plat.link.support.PlatFormRepository;
import com.lq.plat.link.user.InfoUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/27
 */
public interface InfoUserRepository extends PlatFormRepository<InfoUser> {

    /**
     *通过用户名或手机号或邮箱获得用户信息
     * @param username
     * @param status
     * @return
     */
    @Query("from InfoUser u where  (u.mobile =:username or u.email =:username) and u.status =:status")
    InfoUser findByMobileOrEmail(@Param("username") String username,@Param("status") Integer status);

    /**
     * 通过用户名称获得用户信息
     * @param username
     * @param status
     * @return
     */
    InfoUser findByUsernameAndStatus(@Param("username") String username,@Param("status") Integer status);

    /**
     * 通过ID更新用户状态
     * @param status
     * @param id
     */
    @Modifying
    @Query("update InfoUser u set u.status = :status where u.id = :id")
    void updateStatusById(@Param("status") Integer status,@Param("id") Long id);

    @Modifying
    @Query("update InfoUser u set u.portrait = :portrait , u.position = :position ,u.sex = :sex where u.id = :id")
    void update(@Param("portrait") String portrait,@Param("position") String position,@Param("sex")  String sex,@Param("id")   Long id);
}
