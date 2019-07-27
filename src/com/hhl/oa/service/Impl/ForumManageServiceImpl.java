package com.hhl.oa.service.Impl;

import com.hhl.oa.base.DaoSupportImpl;
import com.hhl.oa.domian.ForumManage;
import com.hhl.oa.service.ForumManageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumManageServiceImpl extends DaoSupportImpl<ForumManage> implements ForumManageService {

    @Override
    public List<ForumManage> findAll(){
        return getSession().createQuery("FROM ForumManage f order by f.pos").list();
    }

    @Override
    public void save(ForumManage forumManage) {
        super.save(forumManage);
        forumManage.setPos(forumManage.getId());
    }

    @Override
    public void moveUp(Long id) {
        ForumManage forumManage = this.getById(id);
        ForumManage other = (ForumManage) getSession().createQuery(
                "from ForumManage f where f.pos < ?0 order by f.pos DESC "
                    ).setParameter(0, forumManage.getPos())
                    .setFirstResult(0).setMaxResults(1).uniqueResult();
        if (null == other){
            return;
        }
        Long temp = forumManage.getPos();
        forumManage.setPos(other.getPos());
        other.setPos(temp);
    }

    @Override
    public void moveDown(Long id) {
        ForumManage forumManage = this.getById(id);
        ForumManage other = (ForumManage) getSession().createQuery(
                "from ForumManage f where f.pos > ?0 order by f.pos "
        ).setParameter(0, forumManage.getPos())
                .setFirstResult(0).setMaxResults(1).uniqueResult();

        if (null == other){
            return;
        }

        Long temp = forumManage.getPos();
        forumManage.setPos(other.getPos());
        other.setPos(temp);
    }
}
