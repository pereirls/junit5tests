package br.com.lucas.api.services.impl;

import br.com.lucas.api.domain.UserData;
import br.com.lucas.api.domain.dto.UserDataDTO;
import br.com.lucas.api.repositories.UserRepository;
import br.com.lucas.api.services.UserService;
import br.com.lucas.api.services.exceptions.DataIntegrityViolationException;
import br.com.lucas.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public UserData findById(final Integer id) {
        Optional<UserData> user = repository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<UserData> findAll() {
        return repository.findAll();
    }

    @Override
    public UserData create(UserDataDTO userDataDTO) {
        findByEmail(userDataDTO);

        return repository.save(mapper.map(userDataDTO, UserData.class));
    }

    @Override
    public UserData update(UserDataDTO userDataDTO) {
        findByEmail(userDataDTO);
        return repository.save(mapper.map(userDataDTO, UserData.class));
    }

    @Override
    public void delete(Integer id) {

        findById(id);

        repository.deleteById(id);
    }

    private void findByEmail(UserDataDTO userDataDTO) {
        Optional<UserData> userData = repository.findByEmail(userDataDTO.getEmail());
        if(userData.isPresent() && !userDataDTO.getId().equals(userData.get().getId())){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }
}
