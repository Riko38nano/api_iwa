package api.database.account;

import api.database.account.controllers.AuthoritiesController;
import api.database.account.controllers.UsersController;
import api.database.account.controllers.VerifTokenController;
import api.database.account.controllers.ViewController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class AccountApplicationTests {

    @Autowired
    private UsersController usersController;

    @Autowired
    private AuthoritiesController authoritiesController;

    @Autowired
    private VerifTokenController verifTokenController;

    @Autowired
    private ViewController viewController;

    @Test
    void contextLoads() throws Exception {
        assertThat(usersController).isNotNull();
        assertThat(authoritiesController).isNotNull();
        assertThat(verifTokenController).isNotNull();
        assertThat(viewController).isNotNull();
    }
}
