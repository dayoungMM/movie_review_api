package com.moondy.moviereview.mapper;

import com.moondy.moviereview.dto.ReviewerDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewerMapper {
    List<ReviewerDTO> getAllReviewers();

    boolean insertReviewer(ReviewerDTO reviewerDTO);

    ReviewerDTO getOneReviewer(String id);

    boolean updateReviewer(ReviewerDTO reviewerDTO);

    boolean deleteReviewer(String id);
}
