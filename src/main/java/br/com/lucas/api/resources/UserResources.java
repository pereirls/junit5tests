package br.com.lucas.api.resources;

import br.com.lucas.api.domain.UserData;
import br.com.lucas.api.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserResources {

    UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserData> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }
}
