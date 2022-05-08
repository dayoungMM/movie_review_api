package com.moondy.moviereview.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("ReviewDTO")
@Setter
@Getter
public class ReviewDTO {
    private int seq;
    private int score;
    private LocalDate createdDt;
    private String title;
    private String director;
    private String actor;
    private String comments;
    private String reviewerId;
}
