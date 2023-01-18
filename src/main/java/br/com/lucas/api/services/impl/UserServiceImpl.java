package br.com.lucas.api.services.impl;

import br.com.lucas.api.domain.UserData;
import br.com.lucas.api.repositories.UserRepository;
import br.com.lucas.api.services.UserService;
import br.com.lucas.api.services.exceptions.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public UserData findById(final Integer id) {
        Optional<UserData> user = repository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<UserData> findAll() {
        return repository.findAll();
    }
}
