package com.company.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    private String name;
    private Integer age;
    @Email
    private String email;
    private LocalDateTime createDate;
}
