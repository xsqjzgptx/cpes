package com.atguigu.crowdfunding.cpes.dao;

import com.atguigu.crowdfunding.cpes.bean.Datas;
import com.atguigu.crowdfunding.cpes.bean.Permission;
import com.atguigu.crowdfunding.cpes.bean.Role;
import com.atguigu.crowdfunding.cpes.bean.User;
import com.atguigu.crowdfunding.cpes.bean.UserExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    //登陆
    User getUserByName(String loginacct);

	List<User> getAll(Map<String, Object> paraMetersMap);

	int selectTotalUserCounts();

	void update(User user);

	void delete(Datas datas);

	List<Permission> queryPermissions(User loginUser);
	
	
	//分配角色的四种情况
	void asignRole(@Param("roleid")Integer roleid, @Param("userid")Integer userid);
	void unAssignRole(@Param("roleid")Integer roleid, @Param("userid")Integer userid);
	void asignAll(@Param("userid")Integer userid, @Param("roleIdList")List<Integer> roleIdList);
	void unAssignAll(Integer userid);

	
	
}