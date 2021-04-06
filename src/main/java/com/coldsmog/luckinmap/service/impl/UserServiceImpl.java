package com.coldsmog.luckinmap.service.impl;

import com.coldsmog.luckinmap.common.enums.ExceptionEnum;
import com.coldsmog.luckinmap.common.exception.BusinessException;
import com.coldsmog.luckinmap.mapper.UserMapper;
import com.coldsmog.luckinmap.model.dto.ResetPasswordDto;
import com.coldsmog.luckinmap.model.entity.User;
import com.coldsmog.luckinmap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表，即会员表。(User)表服务实现类
 *
 * @author quanhuan.huang
 * @version 1.0.0
 * @date 2020/03/28 17:16:39
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insertByProperty(User user) {
        return this.userMapper.insertByProperty(user);
    }

    @Override
    public Integer insertBatchByProperty(List<User> list) {
        return this.userMapper.insertBatchByProperty(list);
    }

    @Override
    public Integer updateByPrimaryKey(User user) {
        return this.userMapper.updateByPrimaryKey(user);
    }

    @Override
    public Integer updateBatchByPrimaryKey(List<User> list) {
        return this.userMapper.updateBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return this.userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatchByPrimaryKey(List<Integer> list) {
        return this.userMapper.deleteBatchByPrimaryKey(list);
    }

    @Override
    public Integer deleteByProperty(User user) {
        return this.userMapper.deleteByProperty(user);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectByProperty(User user) {
        return this.userMapper.selectByProperty(user);
    }

    @Override
    public Long countByProperty(User user) {
        return this.userMapper.countByProperty(user);
    }

    @Override
    public User getByToken(String token) {
        return null;
    }

    @Override
    public Integer login(String username, String password) {
        User user = new User();
        user.setName(username);
        User target = this.selectByProperty(user).get(0);
        if (null == target) {
            throw new BusinessException(ExceptionEnum.USER_NOT_EXIST);
        } else if (password.equals(target.getPassword())) {
            throw new BusinessException(ExceptionEnum.USER_PASSWORD_ERROR);
        }
        return target.getId();
    }

    @Override
    public boolean logout(String token) {
        return false;
    }

    @Override
    public Integer updateStatus(Integer adminId) {
        return null;
    }

    @Override
    public String getToken(Integer id) {
        return null;
    }

    @Override
    public String refreshToken(String token) {
        return null;
    }

    @Override
    public User getAdmin() {
        return null;
    }

    @Override
    public Integer resetPassword(ResetPasswordDto resetPasswordDto) {
        return null;
    }


}
