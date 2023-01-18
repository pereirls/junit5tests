package br.com.lucas.api.services;

import br.com.lucas.api.domain.UserData;

public interface UserService {

    UserData findById(final Integer id);
}
