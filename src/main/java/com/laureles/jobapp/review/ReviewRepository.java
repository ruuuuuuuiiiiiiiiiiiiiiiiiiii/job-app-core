package com.laureles.jobapp.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByCompanyId(Long companyId);
    Review findByCompanyIdAndId(Long companyId, Long id);
    boolean existsByCompanyId(Long companyId);
    boolean existsByCompanyIdAndId(Long companyId, Long id);
    void deleteByCompanyIdAndId(Long companyId, Long id);
}
