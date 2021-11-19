package api.database.account;

import api.database.account.controllers.UsersController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class HttpRequest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsersController usersController;

    @Test
    public void loginShouldReturnPage() throws Exception {
        this.mockMvc.perform(get("/login")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Login Page")));
    }

    @Test
    @DisplayName("GET /api/user/1 - Denied")
    void testUserDenied() throws Exception {
        // Get user
        mockMvc.perform(get("/api/user/{id}", 1))
                .andExpect(status().is3xxRedirection());
    }
}
