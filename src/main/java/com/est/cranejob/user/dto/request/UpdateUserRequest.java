package com.est.cranejob.user.dto.request;

import com.est.cranejob.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

/**
 * DTO for {@link com.est.cranejob.user.domain.User}
 */

@Data
@Builder
public class UpdateUserRequest {

    @NotBlank(message = "비밀번호는 빈칸을 입력할 수 없습니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$"
            , message = "현재 비밀번호를 입력해 주세요.")
    private String password;

    @NotBlank(message = "비밀번호는 빈칸을 입력할 수 없습니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$"
            , message = "변경할 비밀번호를 입력해 주세요.")
    private String newPassword;

    @NotBlank(message = "이름은 빈칸을 입력할 수 없습니다.")
    private String userName;
}
