package com.moondy.moviereview.mapper;

import com.moondy.moviereview.dto.ReviewDTO;
import com.moondy.moviereview.dto.ReviewFullDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    List<ReviewDTO> getAllReviews();

    boolean insertReview(ReviewDTO reviewDTO);

    List<ReviewFullDTO> getAllWithRname();
}
