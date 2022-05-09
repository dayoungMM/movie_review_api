package com.moondy.moviereview.dto;

import java.time.LocalDate;
import javax.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("ReviewFullDTO")
@Setter
@Getter
public class ReviewFullDTO {
    private int seq;
    private int score;
    private LocalDate createdDt;
    private String title;
    private String director;
    private String actor;
    private String comments;
    private String reviewerId;
    private String reviewerName;
}
