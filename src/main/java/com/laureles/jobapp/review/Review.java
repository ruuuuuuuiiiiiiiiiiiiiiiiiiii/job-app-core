package com.laureles.jobapp.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laureles.jobapp.company.Company;
import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reviewTitle")
    private String reviewTitle;

    @Column(name = "reviewContent")
    private String reviewContent;

    @Column(name = "rating")
    private double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;

    public Review() {
    }

    public Review(Long id, String reviewTitle, String reviewContent, double rating, Company company) {
        this.id = id;
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
        this.rating = rating;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
