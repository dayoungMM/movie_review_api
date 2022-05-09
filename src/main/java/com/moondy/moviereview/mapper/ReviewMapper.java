package com.moondy.moviereview.mapper;

import com.moondy.moviereview.dto.ReviewDTO;
import com.moondy.moviereview.dto.ReviewFullDTO;
import com.moondy.moviereview.dto.ReviewRegisterDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    List<ReviewDTO> getAllReviews();

    boolean insertReview(ReviewRegisterDTO reviewRegDTO);

    List<ReviewFullDTO> getAllWithRname();
}
