package com.laureles.jobapp.review.impl;

import com.laureles.jobapp.company.Company;
import com.laureles.jobapp.company.CompanyRepository;
import com.laureles.jobapp.company.CompanyService;
import com.laureles.jobapp.review.Review;
import com.laureles.jobapp.review.ReviewRepository;
import com.laureles.jobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private CompanyService companyService;
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(CompanyService companyService, ReviewRepository reviewRepository) {
        this.companyService = companyService;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        if (reviews != null) {
            return reviews;
        } else {
            return null;
        }
    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {

        // much efficient
        Review review = reviewRepository.findByCompanyIdAndId(companyId, reviewId);

        if (review != null) {
            return review;
        } else {
            return null;
        }

        // inefficient
//        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
//        return reviews.stream()
//                .filter(review -> review.getId().equals(reviewId))
//                .findFirst()
//                .orElse(null);
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);

        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateReviewById(Long companyId, Long reviewId, Review updatedReview) {
        try {

            if (companyService.getCompanyById(companyId) != null) {
                Review review = reviewRepository.findByCompanyIdAndId(companyId, reviewId);
                if (review != null) {
                    review.setReviewTitle(updatedReview.getReviewTitle());
                    review.setReviewContent(updatedReview.getReviewContent());
                    review.setRating(updatedReview.getRating());
                    review.setCompany(companyService.getCompanyById(companyId));

                    reviewRepository.save(review);

                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteReviewById(Long companyId, Long reviewId) {
        try {
            if (companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
                Review review = reviewRepository.findByCompanyIdAndId(companyId, reviewId);

                if (review != null) {
                    Company company = review.getCompany();
                    company.getReviews().remove(review);
                    companyService.updateCompanyById(company, companyId);

                    reviewRepository.deleteById(reviewId);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
