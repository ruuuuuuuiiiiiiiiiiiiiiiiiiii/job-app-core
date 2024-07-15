package com.laureles.jobapp.company;

import com.laureles.jobapp.job.Job;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company getCompanyById(Long id);

    boolean createCompany(Company company);

    boolean updateCompanyById(Company updatedCompany, Long id);

    boolean deleteCompanyById(Long id);

}
