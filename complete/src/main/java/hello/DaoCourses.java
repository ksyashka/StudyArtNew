package hello;

import model.Course;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ksyashka on 09.04.2017.
 */
public class DaoCourses {
    private Map<String, Course> courses;

    public DaoCourses() {
        courses = new HashMap<>();
    }

    public boolean addCourse(Course course){
        if (course.getGitHubUrl() == null) return false;
        courses.put(course.getGitHubUrl(),course);
        return true;
    }

}
