package br.com.lucas.api.services;

import br.com.lucas.api.domain.UserData;

import java.util.List;

public interface UserService {

    UserData findById(final Integer id);

    List<UserData> findAll();
}
