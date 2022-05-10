package com.moondy.moviereview.dto;

import java.time.LocalDate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.lang.Nullable;

@Alias("ReviewDTO")
@Setter
@Getter
public class ReviewDTO {
    @NotNull(message = "seq는 필수 인자입니다.")
    private int seq;

    @Max(value = 5, message = "점수는 0~5 사이의 숫자여야 합니다.")
    @Min(value = 0, message = "점수는 0~5 사이의 숫자여야 합니다.")
    private int score;

    @Null(message = "등록일자는 수정할 수 없습니다.")
    private LocalDate createdDt;

    private String title;

    private String director;

    private String actor;

    private String comments;

    @Null(message = "작성자의 ID는 수정할 수 없습니다.")
    private String reviewerId;
}
