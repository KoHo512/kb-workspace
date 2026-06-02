package com.example.jdbc.service;

import com.example.jdbc.common.TransactionManager;
import com.example.jdbc.dao.UserDao;
import com.example.jdbc.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * UserService
 * ------------------------------------------------------------
 * users 관련 비즈니스 로직을 담당합니다.
 *
 * 변경 핵심:
 * - findById/delete/update는 DB PK인 id 기준입니다.
 * - findByUserId는 로그인 ID인 userid 기준입니다.
 */
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Integer save(User user) throws Exception {
        validateForSave(user);

        return TransactionManager.execute(
                con -> {
                    if (userDao.findByUserId(con, user.getUserId()).isPresent()) {
                        throw new IllegalArgumentException("이미 존재하는 userid입니다: " + user.getUserId());
                    }

                    return userDao.insert(con, user);
                }
        );
    }

    public Optional<User> findById(Integer id) throws Exception {
        return TransactionManager.execute(
                con -> userDao.findById(con, id)
        );
    }

    public Optional<User> findByUserId(String userId) throws Exception {
        return TransactionManager.execute(
                con -> userDao.findByUserId(con, userId)
        );
    }

    public List<User> findAll() throws Exception {
        return TransactionManager.execute(userDao::findAll);
    }

    public int update(User user) throws Exception {
        if (user.getId() == null) {
            throw new IllegalArgumentException("수정하려면 User.id가 필요합니다.");
        }

        validateForSave(user);

        return TransactionManager.execute(
                con -> userDao.update(con, user)
        );
    }

    public int delete(Integer id) throws Exception {
        return TransactionManager.execute(
                con -> userDao.delete(con, id)
        );
    }

    public boolean existsByUserId(String userId) throws Exception {
        return findByUserId(userId).isPresent();
    }

    private void validateForSave(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User 객체가 null입니다.");
        }

        if (user.getUserId() == null || user.getUserId().isBlank()) {
            throw new IllegalArgumentException("userid는 필수입니다.");
        }

        if (user.getUsername() == null || user.getUsername().isBlank()) {
            throw new IllegalArgumentException("username은 필수입니다.");
        }

        if (user.getUserPassword() == null || user.getUserPassword().isBlank()) {
            throw new IllegalArgumentException("userpassword는 필수입니다.");
        }
    }
}
