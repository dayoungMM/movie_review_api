package com.moondy.moviereview.controller;

import com.moondy.moviereview.dto.ReviewDTO;
import com.moondy.moviereview.dto.ReviewerDTO;
import com.moondy.moviereview.service.ReviewerService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviewer")
public class ReviewerController {
    private final ReviewerService reviewerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ReviewerDTO>> getAllReviewer() {
        List<ReviewerDTO> result = reviewerService.getAllReviewerSvc();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @PostMapping("/add")
    public ResponseEntity<String> addReviewer(@RequestBody @Valid  ReviewerDTO reviewerDTO) {
        String result = reviewerService.insertReviewer(reviewerDTO);
        return new ResponseEntity (result, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @PostMapping("/update")
    public ResponseEntity<String> updateReviewer(@RequestBody @Valid ReviewerDTO reviewerDTO) {
        String result = reviewerService.updateReviewer(reviewerDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }





}
