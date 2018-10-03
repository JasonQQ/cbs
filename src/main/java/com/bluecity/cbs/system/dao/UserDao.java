package com.bluecity.cbs.system.dao;

import com.bluecity.cbs.system.domain.UserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 *
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-10-03 14:11:01
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
