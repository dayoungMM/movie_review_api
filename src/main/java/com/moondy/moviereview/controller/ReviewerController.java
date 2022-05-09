package com.moondy.moviereview.controller;

import com.moondy.moviereview.dto.ReviewerDTO;
import com.moondy.moviereview.service.ReviewerService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/getOne/{id}")
    public ResponseEntity<ReviewerDTO> getOneReviewer(@PathVariable("id") String id) {
        ReviewerDTO result = reviewerService.getOne(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @PostMapping("/add")
    public ResponseEntity<String> addReviewer(@RequestBody @Valid  ReviewerDTO reviewerDTO) {
        String result = reviewerService.insertReviewer(reviewerDTO);
        return new ResponseEntity (result, HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @PutMapping("/update")
    public ResponseEntity<String> updateReviewer(@RequestBody @Valid ReviewerDTO reviewerDTO) {
        String result = reviewerService.updateReviewer(reviewerDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReviewer(@PathVariable("id") String id) {
        String result = reviewerService.deleteReviewer(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
