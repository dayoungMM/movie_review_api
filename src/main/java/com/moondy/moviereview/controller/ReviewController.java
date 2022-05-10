package com.moondy.moviereview.controller;

import com.moondy.moviereview.dto.ReviewDTO;
import com.moondy.moviereview.dto.ReviewFullDTO;
import com.moondy.moviereview.dto.ReviewRegisterDTO;
import com.moondy.moviereview.service.ReviewService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ReviewDTO>> getAllReview() {
        List<ReviewDTO> result = reviewService.getAll();
        return new ResponseEntity (result,HttpStatus.OK);
    }

    @GetMapping("/getAllFull")
    public ResponseEntity<List<ReviewFullDTO>> getAllFull() {
        List<ReviewFullDTO> result = reviewService.getAllFull();
        return new ResponseEntity (result,HttpStatus.OK);
    }

    @GetMapping("/getByTitle/{title}")
    public ResponseEntity<List<ReviewDTO>> getByTitle(@PathVariable("title") String title) {
        List<ReviewDTO> result = reviewService.getByTitle(title);
        return new ResponseEntity (result,HttpStatus.OK);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @PostMapping("/add")
    public ResponseEntity<String> addReview(@RequestBody @Valid ReviewRegisterDTO reviewRegDTO) {
        String result = reviewService.insertReview(reviewRegDTO);
        return new ResponseEntity (result, HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<String> updateReview(@RequestBody @Valid ReviewDTO reviewDTO) {
        String result = reviewService.updateReview(reviewDTO);
        return new ResponseEntity (result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{seq}")
    public ResponseEntity<String> deleteReviewer(@PathVariable("seq") int seq) {
        String result = reviewService.deleteReview(seq);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
