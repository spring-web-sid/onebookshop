package com.onebookshop.service.impl;

import com.onebookshop.dao.UserDao;
import com.onebookshop.dto.UserData;
import com.onebookshop.model.UserModel;
import com.onebookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    private static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";
    @Autowired
    private UserDao userDao;
    @Override
    public UserModel getCurrentUser() {
        UserData user = (UserData)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDao.getUserByUid(user.getUserId());
    }

    @Override
    public Boolean isCurrentUserAnonymous() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return null != auth ? auth.getAuthorities().stream().findFirst().get().getAuthority().equalsIgnoreCase(ROLE_ANONYMOUS) : Boolean.FALSE;
    }

}
