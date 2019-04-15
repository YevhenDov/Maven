package com;

import com.service.ProjectService;
import com.entity.Developer;
import com.entity.Project;
import com.service.DeveloperService;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws SQLException {
        DeveloperService developerService = new DeveloperService();
        Developer developer = new Developer();
        ProjectService projectService = new ProjectService();
        developer.setAge(25);
        developer.setName("Ann");
        developer.setGender("female");
        developer.setSalary(1000);
        Set<Developer> developers = new HashSet<>();
        developers.add(developer);

        Project project = new Project();
        project.setCost("10000");
        project.setName("App");
        project.setDeadLine("10.10.2019");
        Set<Project> projects = new HashSet<>();
        projects.add(project);
        developerService.save(developer);
        projectService.save(project);


    }
}
