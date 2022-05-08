package com.moondy.moviereview.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("ReviewerDTO")
@Getter
@Setter
public class ReviewerDTO {
    private String id;
    private String name;
}
