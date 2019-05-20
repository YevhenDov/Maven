package com.company.transformer;

import com.company.dto.User;
import com.company.entity.UserEntity;
import com.company.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserTransformer {

    @Autowired
    UserEntityRepository repository;

    UserEntity userEntity;

    public UserEntity buildEntity(User user){
        if (user.getId() == null) {
            userEntity = new UserEntity();
        }
        else
            userEntity = repository.findById(user.getId()).get();

        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());

        return userEntity;
    }

    public User buildUser(UserEntity userEntity){
        User user = new User()
                .setName(userEntity.getName())
                .setAge(userEntity.getAge())
                .setEmail(userEntity.getEmail())
                .setCreateDate(userEntity.getCreatedDate());

        if (userEntity.getId() != null)
            user.setId(userEntity.getId());

        return user;
    }
}
