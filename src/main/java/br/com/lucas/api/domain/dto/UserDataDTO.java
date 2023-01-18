package br.com.lucas.api.domain.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDTO {

    private Integer id;
    private String name;
    private String email;
    private String password;
}
