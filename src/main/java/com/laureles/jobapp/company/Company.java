package com.laureles.jobapp.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laureles.jobapp.job.Job;
import com.laureles.jobapp.review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "companyDescription")
    private String companyDescription;

    @Column(name = "companyLocation")
    private String companyLocation;

    @JsonIgnore // remove infinite loop
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

//    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    public Company() {
    }

    public Company(Long id, String companyName, String companyDescription, String companyLocation, List<Job> jobs, List<Review> reviews) {
        this.id = id;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.companyLocation = companyLocation;
        this.jobs = jobs;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
