package com.company.dao.daoimpl;

import com.company.dao.UserDao;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
    private static final String CREATE = "INSERT INTO users (name, age) VALUES (?, ?)";
    private static final String READ = "SELECT * FROM users WHERE id = ?";
    private static final String UPDATE = "UPDATE users SET name = ?, age = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM Users WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createUser(User user) {
        jdbcTemplate.update(CREATE, new Object[]{user.getName(), user.getAge()});
    }

    @Override
    public Optional<User> getUserById(int id) {
        Optional<User> optionalUser = Optional.of(jdbcTemplate.queryForObject(READ, new Object[]{id}, new BeanPropertyRowMapper<>(User.class)));
        return optionalUser;
    }

    @Override
    public void updateUser(int id, User user) {
        jdbcTemplate.update(UPDATE, user.getName(), user.getAge(), id);
    }

    @Override
    public void deleteUser(int id) {
        jdbcTemplate.update(DELETE, id);
    }
}
