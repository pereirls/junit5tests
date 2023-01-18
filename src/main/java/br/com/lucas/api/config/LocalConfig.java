package br.com.lucas.api.config;

import br.com.lucas.api.domain.UserData;
import br.com.lucas.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB() {
        UserData u1 = new UserData(null, "Lucas", "lucas@mail.com", "123");
        UserData u2 = new UserData(null, "Lucas1", "lucas1@mail.com", "123");

        repository.saveAll(List.of(u1, u2));

    }
}
