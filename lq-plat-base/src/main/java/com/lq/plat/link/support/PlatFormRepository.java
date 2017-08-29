/**
 * 
 */
package com.lq.plat.link.support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author zhailiang
 *
 */
@NoRepositoryBean
public interface PlatFormRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {



}
