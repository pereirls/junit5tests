package br.com.lucas.api.resources;

import br.com.lucas.api.domain.UserData;
import br.com.lucas.api.domain.dto.UserDataDTO;
import br.com.lucas.api.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserResourcesTest {

    @InjectMocks
    private UserResources userResources;

    @Mock
    private ModelMapper mapper;

    @Mock
    private UserService userService;

    public static final Integer ID = 1;
    public static final String NAME = "lucas";
    public static final String EMAIL = "lucas@mail.com";
    public static final String PASSWORD = "1234";
    public static final String OBJECT_NOT_FOUND = "Objeto não encontrado";
    public static final String EMAIL_JA_CADASTRADO_NO_SISTEMA = "Email já cadastrado no sistema";

    private UserData userData;
    private UserDataDTO userDataDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsers();
    }

    @Test
    void findById() {
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
    }
}