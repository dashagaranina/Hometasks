package api;


import model.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import static api.fixture.RestDataFixture.standardUserJSON;
import static api.fixture.RestDataFixture.standardUserList;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static repository.fixture.TestConstants.UserConstants.*;
import static repository.fixture.TestData.standardUser;

public class UserRestControllerTest {
    MockMvc mockMvc;

    private final String BASE_URL = "/api/user";

    @InjectMocks
    controller.api.UserRestController controller;

    @Mock
    repository.UserRepository userRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = standaloneSetup(controller)
                .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @Test
    public void thatFindUserById() throws Exception {
        //описываем поведение мока при вызове метода findOne
        when(userRepository.findOne(any(Long.class))).thenReturn(standardUser());
        //делаем GET-запрос и проверяем содержимое полученного json-документа
        this.mockMvc.perform(
                get(BASE_URL + "/{id}", 1L).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.name").value(USER_NAME))
                .andExpect(jsonPath("$.city").value(USER_CITY))
                .andExpect(jsonPath("$.gender").value(USER_GENDER.name()));
    }

    @Test
    public void thatFindUserById_NotFound() throws Exception {
        when(userRepository.findOne(any(Long.class))).thenReturn(null);
        this.mockMvc.perform(
                get(BASE_URL + "/{id}", 1L).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateUser() throws Exception {
        when(userRepository.save(any(User.class))).thenReturn(standardUser());
        this.mockMvc.perform(
                put(BASE_URL+ "/{id}", 1L)
                        .content(standardUserJSON())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    //тест добавления нового пользователя
    @Test
    public void testCreateUser() throws Exception {
        this.mockMvc.perform(
                post(BASE_URL)
                        .content(standardUserJSON())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    //тест удаления пользователя
    @Test
    public void testDeleteUser() throws Exception {
        when(userRepository.exists(anyLong()))
                .thenReturn(true);

        Long key = 1L;
        this.mockMvc.perform(
                delete(BASE_URL + "/{id}", key)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        verify(userRepository).delete(argThat(Matchers.equalTo(key)));
    }

    @Test
    public void testFindAllUsersSuccessfully() throws Exception {
        when(userRepository.findAll()).thenReturn(standardUserList());
        this.mockMvc.perform(
                get(BASE_URL + "/all").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
