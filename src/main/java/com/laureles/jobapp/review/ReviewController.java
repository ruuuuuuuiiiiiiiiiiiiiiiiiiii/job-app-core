package com.laureles.jobapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies/{companyId}/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable("companyId") Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable("companyId") Long companyId, @PathVariable("reviewId") Long reviewId) {
        Review review = reviewService.getReviewById(companyId, reviewId);

        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> createReview(@PathVariable("companyId") Long companyId, @RequestBody Review review) {
        boolean isCreated = reviewService.createReview(companyId, review);

        if (isCreated) {
            return new ResponseEntity<>("Created Successfully!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Review Not Created!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable("companyId") Long companyId, @PathVariable("reviewId") Long reviewId, @RequestBody Review updatedReview) {
        boolean isUpdated = reviewService.updateReviewById(companyId, reviewId, updatedReview);

        if (isUpdated) {
            return new ResponseEntity<>("Updated Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review Not Updated!", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable("companyId") Long companyId, @PathVariable("reviewId") Long reviewId) {
        boolean isDeleted = reviewService.deleteReviewById(companyId, reviewId);

        if (isDeleted) {
            return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review Not Deleted!", HttpStatus.BAD_REQUEST);
        }
    }



}
