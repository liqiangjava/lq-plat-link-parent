package com.lq.plat.link.repository;

import com.lq.plat.link.knowledage.MonthBestResponderDto;
import com.lq.plat.link.utils.DTOUtils;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/2
 */
@Repository
public class KnowledgeAnswerDao {



    @Autowired
    private EntityManager entityManager;

    public List<MonthBestResponderDto> monthBestResponder(Integer size) {
        Query query = entityManager.createNativeQuery("select  count(ka.create_user) as count ,iu.mobile as mobile ,iu.email as email,iu.login_model as loginModel,iu.username as username,iu.description as description,iu.sex as sex,iu.portrait as portrait,iu.position as position from knowledge_answer ka inner join info_user iu on ka.create_user = iu.id where date_format(ka.create_date,'%Y-%m') = date_format(now(),'%Y-%m') group by ka.create_user order by count desc limit "+size);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List rows = query.getResultList();
        List<MonthBestResponderDto> monthBestResponderDtos = DTOUtils.map(rows, MonthBestResponderDto.class);
        return monthBestResponderDtos;
    }

}
