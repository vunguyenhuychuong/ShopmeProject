package com.shopme.shopmebackend;


import com.shopme.common.entity.Role;
import com.shopme.shopmebackend.repositores.RoleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateFirstRole() {
        Role roleAdmin = new Role("Admin", "manage everything");
        Role savedRole = repo.save(roleAdmin);
        Assertions.assertThat(savedRole.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateRestRoles() {
        Role roleSaleperson = new Role("Saleperson", "manage product price"
                + "customers, shipping, orders and sales report");
        Role roleEditor = new Role ("Editor", "manage categories, brands,"
                + "products, shipping, orders and sales report");
        Role roleShipper = new Role("Shipper", "view products, view orders "
                +"and update order status");
        Role roleAssistant = new Role("Assistant", "manage questions and reviews");
        repo.saveAll(List.of(roleSaleperson, roleEditor, roleShipper, roleAssistant));
    }
}
