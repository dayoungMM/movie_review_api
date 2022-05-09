package com.moondy.moviereview.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.lang.NonNull;

@Alias("ReviewerDTO")
@Getter
@Setter
public class ReviewerDTO {
//    @NotBlank(message = "id는 필수 값입니다.")
    @Pattern(regexp = "[a-z0-9]+", message = "id는 소문자 영어와 숫자로 이루어져있어야 합니다")
    private String id;

    @NotBlank(message = "name은 필수 값입니다.")
    private String name;
}
