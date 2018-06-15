package com.bootgo.system.dao;

import com.bootgo.system.domain.UserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author wz
 * @email 358812885@qq.com
 * @date 2018-06-14 10:29:28
 */
@Mapper
public interface UserDao {

	UserDO get(Long userId);
	
	List<UserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserDO user);
	
	int update(UserDO user);
	
	int remove(Long user_id);
	
	int batchRemove(Long[] userIds);
}
