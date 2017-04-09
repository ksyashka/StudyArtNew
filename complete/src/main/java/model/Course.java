package model;

import java.util.List;

/**
 * Created by ksyashka on 09.04.2017.
 */
public class Course {
    private String gitHubUrl;
    private String author;
    private List<Lesson> lessons;

    public Course(String gitHubUrl, String author, List<Lesson> lessons) {
        this.gitHubUrl = gitHubUrl;
        this.author = author;
        this.lessons = lessons;
    }

    public Course(String gitHubUrl, String author) {
        this.gitHubUrl = gitHubUrl;
        this.author = author;
    }

    public Course() {
    }

    public String getGitHubUrl() {
        return gitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
