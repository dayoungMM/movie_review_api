package com.moondy.moviereview.mapper;

import com.moondy.moviereview.dto.ReviewDTO;
import com.moondy.moviereview.dto.ReviewerDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieReviewMapper {
    List<ReviewDTO> getAllReviews();

    List<ReviewerDTO> getAllReviewers();


}
