package com;

import com.entity.Company;
import com.entity.Developer;
import com.entity.Skill;
import com.daoimpl.CompanyDaoImpl;
import com.daoimpl.ProjectDaoImpl;
import com.entity.Project;
import com.enumrep.Gender;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws SQLException {
        Company company = new Company();
        Project project = new Project();
        Developer developer = new Developer();
        CompanyDaoImpl companyDaoImpl = new CompanyDaoImpl();
        ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();

        company.setName("Apple");
        company.setAddress("Odessa");
        companyDaoImpl.update(company);
        project.setName("App");
        project.setDeadLine(LocalDateTime.now());
        project.setCost(15000);
        projectDaoImpl.create(project);
        developer.setGender(Gender.MALE);

        company = companyDaoImpl.findById(1);
        System.out.println(company);

        Skill skill = new Skill();

    }
}
