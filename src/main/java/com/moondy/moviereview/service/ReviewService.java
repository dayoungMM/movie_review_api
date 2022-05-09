package com.moondy.moviereview.service;

import com.moondy.moviereview.dto.ReviewFullDTO;
import com.moondy.moviereview.mapper.ReviewMapper;
import com.moondy.moviereview.dto.ReviewDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewMapper reviewMapper;
    private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);

    public List<ReviewDTO> getAll() {
        return reviewMapper.getAllReviews();
    }

    public boolean insertReview(ReviewDTO reviewDTO) {
        boolean result = false;
        try {
            result = reviewMapper.insertReview(reviewDTO);
        } catch (Exception e) {
            logger.info(">>> " + e);
        }
        return result;
    }

    public List<ReviewFullDTO> getAllFull() {
        return reviewMapper.getAllWithRname();
    }
}
