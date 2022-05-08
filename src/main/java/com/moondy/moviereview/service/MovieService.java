package com.moondy.moviereview.service;

import com.moondy.moviereview.dto.ReviewerDTO;
import com.moondy.moviereview.mapper.MovieReviewMapper;
import com.moondy.moviereview.dto.ReviewDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieReviewMapper movieReviewMapper;

    public List<ReviewDTO> getAllReviewSvc() {
        return movieReviewMapper.getAllReviews();
    }

    public List<ReviewerDTO> getAllReviewerSvc() {
        return movieReviewMapper.getAllReviewers();
    }

}
