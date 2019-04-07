package com.onebookshop.service;

import com.onebookshop.model.UserModel;

public interface UserService {
    UserModel getCurrentUser();
    Boolean isCurrentUserAnonymous();

}
