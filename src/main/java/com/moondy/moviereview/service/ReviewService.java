package com.moondy.moviereview.service;

import com.moondy.moviereview.dto.ReviewFullDTO;
import com.moondy.moviereview.dto.ReviewRegisterDTO;
import com.moondy.moviereview.dto.ReviewerDTO;
import com.moondy.moviereview.mapper.ReviewMapper;
import com.moondy.moviereview.dto.ReviewDTO;
import com.moondy.moviereview.mapper.ReviewerMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewMapper reviewMapper;
    private final ReviewerMapper reviewerMapper;
    private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);

    public List<ReviewDTO> getAll() {
        return reviewMapper.getAllReviews();
    }

    public String insertReview(ReviewRegisterDTO reviewRegDTO) {
        String result = "실패";
        try {
            ReviewerDTO reviewer = reviewerMapper.getOneReviewer(reviewRegDTO.getReviewerId());
            if (reviewer == null) {
                return "작성자의 ID가 존재하지 않습니다.";
            }
            result = reviewMapper.insertReview(reviewRegDTO) ? "성공" : result ;
        } catch (Exception e) {
            logger.info(">>> " + e);
        }
        return result;
    }

    public List<ReviewFullDTO> getAllFull() {
        return reviewMapper.getAllWithRname();
    }

    public String updateReview(ReviewDTO reviewDTO) {
        String result = "실패";
        try {
            ReviewDTO target = reviewMapper.getOneReview(reviewDTO.getSeq());
            if (target == null) {
                return "존재하지 않는 리뷰입니다. seq가 정확한지 확인해주세요.";
            }
            target.setTitle(reviewDTO.getTitle() == null ? target.getTitle() : reviewDTO.getTitle());
            target.setDirector(reviewDTO.getDirector() == null ? target.getDirector() : reviewDTO.getDirector());
            target.setActor(reviewDTO.getActor() == null ? target.getActor() : reviewDTO.getActor());
            target.setComments(reviewDTO.getComments() == null ? target.getComments() : reviewDTO.getComments());
            target.setScore(reviewDTO.getScore());

            result = reviewMapper.updateReview(target) ? "성공" : "실패";
        } catch (Exception e) {
            logger.info(">>> " + e);
        }
        return result;
    }

    public String deleteReview(int seq) {
        String result = "실패";
        try {
            result = reviewMapper.deleteReview(seq) ? "성공" : "실패. seq를 확인하세요.";
        } catch (Exception e) {
            logger.info(">>> " + e);
        }
        return result;
    }

    public List<ReviewDTO> getByTitle(String title) {
        List<ReviewDTO> result = null;
        try {
            result = reviewMapper.getAllByTitle(title);
        } catch (Exception e) {
            logger.info(">>> " + e);
        }
        return result;
    }
}
