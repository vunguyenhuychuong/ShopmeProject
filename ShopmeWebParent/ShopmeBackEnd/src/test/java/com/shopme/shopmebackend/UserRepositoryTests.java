package com.shopme.shopmebackend;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import com.shopme.shopmebackend.repositores.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        Role roleAdmin = entityManager.find(Role.class, 1);
        User userChuongvnh = new User("chuong@codejava.net", "chuong2022", "Chuong", "Vu Nguyen Huy");
        userChuongvnh.addRole(roleAdmin);

        User savedUser = repo.save(userChuongvnh);

        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateNewUserWithTwoRoles() {
        User userHiep = new User("Hiep@gmail.com", "hiep2022", "Hiep", "Tran Thanh");
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(5);

        userHiep.addRole(roleEditor);
        userHiep.addRole(roleAssistant);

        User savedUser = repo.save(userHiep);

        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers() {
       Iterable<User> listUsers =  repo.findAll();
       listUsers.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserById() {
        User userChuong = repo.findById(1).get();
        System.out.println(userChuong);
        Assertions.assertThat(userChuong).isNotNull();
    }

    @Test
    public void testUpdateUserDetails() {
        User userChuong = repo.findById(1).get();
        userChuong.setEnabled(true);
        userChuong.setEmail("chuongjavapro@gmail.com");

        repo.save(userChuong);
    }

    @Test
    public void testUpdateUserRoles() {
        User userHiep = repo.findById(2).get();
        Role roleEditor = new Role(3);
        Role roleSaleperson = new Role(2);
        userHiep.getRoles().remove(roleEditor);
        userHiep.addRole(roleSaleperson);

        repo.save(userHiep);
    }

    @Test
    public void testDeleteUser() {
        Integer userId = 2;
        repo.deleteById(userId);

    }

    @Test
    public void testGetUserByEmail() {
        String email = "chuongjavapro@gmail.com";
        User user =  repo.getUserByEmail(email);

        Assertions.assertThat(user).isNotNull();
    }

    @Test
    public void testCountById() {
        Integer id = 1;
        Long countById = repo.countById(id);

        Assertions.assertThat(countById).isNotNull().isGreaterThan(0);
    }

    @Test
    public void testDisabledUser() {
        Integer id = 1;
        repo.updateEnabledStatus(id, false);
    }

    @Test
    public void testDisableUser() {
        Integer id = 14;
        repo.updateEnabledStatus(id, false);
    }

    @Test
    public void testEnableUser() {
        Integer id = 14;
        repo.updateEnabledStatus(id, true);
    }
}
