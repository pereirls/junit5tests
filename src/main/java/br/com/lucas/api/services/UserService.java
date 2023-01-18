package br.com.lucas.api.services;

import br.com.lucas.api.domain.UserData;
import br.com.lucas.api.domain.dto.UserDataDTO;

import java.util.List;

public interface UserService {

    UserData findById(final Integer id);

    List<UserData> findAll();

    UserData create(UserDataDTO userDataDTO);

    UserData update(UserDataDTO userDataDTO);
}
