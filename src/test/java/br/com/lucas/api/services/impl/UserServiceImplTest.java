package br.com.lucas.api.services.impl;

import br.com.lucas.api.domain.UserData;
import br.com.lucas.api.domain.dto.UserDataDTO;
import br.com.lucas.api.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID      = 1;
    public static final String NAME     = "lucas";
    public static final String EMAIL    = "lucas@mail.com";
    public static final String PASSWORD = "1234";
    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Mock
    private ModelMapper mapper;

    private UserData userData;
    private UserDataDTO userDataDTO;
    private Optional<UserData> userDataOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsers();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(userDataOptional);

        UserData response = service.findById(ID);

        assertNotNull(response);
        assertEquals(UserData.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(PASSWORD, response.getPassword());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUsers() {
        userData = new UserData(ID, NAME, EMAIL, PASSWORD);
        userDataDTO = new UserDataDTO(ID, NAME, EMAIL, PASSWORD);
        userDataOptional = Optional.of(new UserData(ID, NAME, EMAIL, PASSWORD));
    }
}