package com.company.transformer;

import com.company.dto.User;
import com.company.entity.UserEntity;
import com.company.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer {

    @Autowired
    private UserEntityRepository repository;

    private UserEntity userEntity;

    public UserEntity buildEntity(User user) {
        userEntity = new UserEntity();

        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setAge(user.getAge());
        userEntity.setEmail(user.getEmail());

        return userEntity;
    }

    public User buildUser(UserEntity userEntity) {
        User user = new User()
                .setName(userEntity.getName())
                .setAge(userEntity.getAge())
                .setEmail(userEntity.getEmail())
                .setCreatedDate(userEntity.getCreatedDate())
                .setId(userEntity.getId());

        return user;
    }
}
