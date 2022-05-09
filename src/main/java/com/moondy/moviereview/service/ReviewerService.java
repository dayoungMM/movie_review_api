package com.moondy.moviereview.service;

import com.moondy.moviereview.dto.ReviewerDTO;
import com.moondy.moviereview.mapper.ReviewerMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewerService {
    private final ReviewerMapper reviewerMapper;
    private static final Logger logger = LoggerFactory.getLogger(ReviewerService.class);

    public List<ReviewerDTO> getAllReviewerSvc() {
        return reviewerMapper.getAllReviewers();
    }

    public String insertReviewer(ReviewerDTO reviewerDTO) {
        String result = "실패";
        try {
            ReviewerDTO existRev = reviewerMapper.getOneReviewer(reviewerDTO.getId());
            if (existRev != null) {
                return "아이디가 이미 존재합니다.";
            }
            result = reviewerMapper.insertReviewer(reviewerDTO) ? "성공" : "실패";
        } catch (Exception e) {
            logger.info(">>> " + e);
        }
        return result;
    }

    public String updateReviewer(ReviewerDTO reviewerDTO) {
        String result = "실패";
        try {
            ReviewerDTO target = reviewerMapper.getOneReviewer(reviewerDTO.getId());
            if (target == null) {
                return "존재하지 않는 ID 입니다.";
            }
            result = reviewerMapper.updateReviewer(reviewerDTO) ? "성공" : "실패";
        } catch (Exception e) {
            logger.info(">>> " + e);
        }
        return result;
    }

    public String deleteReviewer(String id) {
        String result = "실패";
        try {
            result = reviewerMapper.deleteReviewer(id) ? "성공" : "실패. ID를 확인해주세요";
        } catch (Exception e) {
            logger.info(">>> " + e);
        }
        return result;
    }

    public ReviewerDTO getOne(String id) {
        ReviewerDTO target = null;
        try {
            target = reviewerMapper.getOneReviewer(id);
            // target 이 존재하지 않을 때 예외처리 하고 싶은데, 추후 CommonResponse 만들게 되면 처리할 예정
        } catch (Exception e) {
            logger.info(">>> " + e);
        }
        return target;
    }
}
