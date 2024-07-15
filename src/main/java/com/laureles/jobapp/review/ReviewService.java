package com.laureles.jobapp.review;

import com.laureles.jobapp.company.Company;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    Review getReviewById(Long companyId, Long reviewId);

    boolean createReview(Long companyId, Review review);

    boolean updateReviewById(Long companyId, Long reviewId, Review updatedReview);

    boolean deleteReviewById(Long companyId, Long reviewId);
}
