package com.lamdayne.service;

import com.lamdayne.model.User;

public interface UserService extends GenericService<User, Long> {
    User findOne(Long id);
}
