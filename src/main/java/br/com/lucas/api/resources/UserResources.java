package br.com.lucas.api.resources;

import br.com.lucas.api.domain.dto.UserDataDTO;
import br.com.lucas.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserResources {

    public static final String ID = "/{id}";
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @GetMapping(value = ID)
    public ResponseEntity<UserDataDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(userService.findById(id), UserDataDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDataDTO>> findAll() {

        return ResponseEntity.ok().body(
                userService.findAll()
                .stream()
                .map(item -> mapper.map(item, UserDataDTO.class))
                .toList());
    }

    @PostMapping
    public ResponseEntity<UserDataDTO> create(@RequestBody UserDataDTO userDataDTO) {
        return ResponseEntity.created(ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path(ID)
                        .buildAndExpand(userService.create(userDataDTO).getId())
                        .toUri()
                ).build();}

    @PutMapping(value = ID)
    public ResponseEntity<UserDataDTO> update(@PathVariable Integer id,
                                              @RequestBody UserDataDTO userDataDTO) {
        userDataDTO.setId(id);
        return ResponseEntity.ok().body(mapper.map(userService.update(userDataDTO), UserDataDTO.class));}

    @DeleteMapping(value = ID)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();}
}
