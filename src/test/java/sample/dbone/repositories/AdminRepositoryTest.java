package sample.dbone.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.Application;
import sample.dbone.models.Admin;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepo;

    @Test
    public void adminRepoTest() throws Exception {
        adminRepo.deleteAll();
        Admin admin = adminRepo.save(new Admin("some name"));

        Admin fetchedAdmin = adminRepo.findOne(admin.getId());

        assertThat(fetchedAdmin).isEqualTo(admin);
    }
}