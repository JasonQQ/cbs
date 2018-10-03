package com.bluecity.cbs.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bluecity.cbs.system.dao.UserDao;
import com.bluecity.cbs.system.domain.UserDO;
import com.bluecity.cbs.system.service.UserService;

/**
 * 
 *
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-10-03 14:11:01
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDO get(Long userId) {
        return userDao.get(userId);
    }

    @Override
    public List<UserDO> list(Map<String, Object> map) {
        return userDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userDao.count(map);
    }

    @Override
    public int save(UserDO user) {
        return userDao.save(user);
    }

    @Override
    public int update(UserDO user) {
        return userDao.update(user);
    }

    @Override
    public int remove(Long userId) {
        return userDao.remove(userId);
    }

    @Override
    public int batchRemove(Long[] userIds) {
        return userDao.batchRemove(userIds);
    }
}
