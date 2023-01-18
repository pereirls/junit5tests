package br.com.lucas.api.repositories;

import br.com.lucas.api.domain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {
    Optional<UserData> findByEmail(String email);
}
