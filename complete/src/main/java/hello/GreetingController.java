package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import model.Course;
import model.Lesson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/course/get")
    public Course getCourse(@RequestParam(value="name", defaultValue="artcode") String name){
        List<String> activeClasses = new ArrayList<>();
        List<String> activeTests = new ArrayList<>();
        activeClasses.add("com.artcode.model.User");
        activeClasses.add("com.artcode.model.Task");
        activeTests.add("com.artcode.model.UserTest");
        activeTests.add("com.artcode.model.TaskTest");
        Lesson lesson = new Lesson ("Lesson1",activeClasses,activeTests);
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(lesson);
        return new Course(name,"testAuthor",lessons);
    }

    @RequestMapping("/robot/get")
    public Robot getRobot(@RequestParam(value="name", defaultValue="artcode") String name){
        String[] commands = {"sing", "dance", "clean"};
        return new Robot(1,"R2D2",10000.0,commands);

    }
    @RequestMapping("/addCourse")
    public boolean addCourse(@RequestBody Course course){
        DaoCourses courses = new DaoCourses();
        return courses.addCourse(course);
   }
}
