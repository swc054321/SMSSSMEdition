package cn.com.zhirun.ssm.dao;

import cn.com.zhirun.ssm.model.MemberModel;

import java.util.List;

public interface CMemberModelMapper extends MemberModelMapper{
    List<MemberModel> selectMembers(MemberModel memberModel);

    List<MemberModel> selectMembersByIds(String[] ids);
}