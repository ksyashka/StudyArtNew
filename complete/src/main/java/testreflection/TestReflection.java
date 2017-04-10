package testreflection;

import model.Course;

import java.util.Arrays;

/**
 * Created by Yuriy on 10.04.2017.
 */
public class TestReflection {

    public static void main(String[] args) {
        Course course = new Course();
        getAllInfo(course);
    }

    public static void getAllInfo(Object object){
        Class cl = object.getClass();

        System.out.println("Fields");
        Arrays.stream(cl.getDeclaredFields()).forEach(System.out::println);

        System.out.println("Methods");
        Arrays.stream(cl.getDeclaredMethods()).forEach(System.out::println);

        System.out.println("Constructor");
        Arrays.stream(cl.getDeclaredConstructors()).forEach(System.out::println);
    }
}
