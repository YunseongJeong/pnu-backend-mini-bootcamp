package com.ll.pnu_backend_mini_bootcamp.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "username은 필수 항목입니다.")
    private String username;

    @NotEmpty(message = "password는 필수 항목입니다.")
    private String password1;
    @NotEmpty(message = "password 확인은 필수 항목입니다.")
    private String password2;

    @NotEmpty(message = "email은 필수 항목입니다.")
    @Email
    private String email;

}
