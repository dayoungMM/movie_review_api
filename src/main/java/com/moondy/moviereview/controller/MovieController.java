package com.moondy.moviereview.controller;

import com.moondy.moviereview.dto.ReviewDTO;
import com.moondy.moviereview.dto.ReviewerDTO;
import com.moondy.moviereview.service.MovieService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/getAllReview")
    public ResponseEntity<List<ReviewDTO>> getAllReview() {
        List<ReviewDTO> result = movieService.getAllReviewSvc();
        return new ResponseEntity (result,HttpStatus.OK);
    }

    @GetMapping("/getAllReviewer")
    public ResponseEntity<List<ReviewerDTO>> getAllReviewer() {
        List<ReviewerDTO> result = movieService.getAllReviewerSvc();
        return new ResponseEntity(result, HttpStatus.OK);
    }

//    @PostMapping("/addReview")
//    public ResponseEntity<ReviewDTO> addReview() {
//
//    }


}
