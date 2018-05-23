package cn.com.zhirun.ssm.service;

import cn.com.zhirun.ssm.dao.CMemberModelMapper;
import cn.com.zhirun.ssm.dao.MemberModelMapper;
import cn.com.zhirun.ssm.model.MemberModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberModelMapper memberModelMapper;

    @Autowired
    CMemberModelMapper cmemberModelMapper;

    public MemberModel selectByPrimaryKey(Integer id){
        return memberModelMapper.selectByPrimaryKey(id);
    }

    public int deleteByPrimaryKey(Integer deleteid){
        return memberModelMapper.deleteByPrimaryKey(deleteid);
    }

    public int insertMember(MemberModel memberModel){
        return memberModelMapper.insert(memberModel);
    }

    public List<MemberModel> selectMembers(MemberModel memberModel){
        return cmemberModelMapper.selectMembers(memberModel);
    }

    public List<MemberModel> selectMembersByIds(String[] ids){
        return cmemberModelMapper.selectMembersByIds(ids);
    }
}
