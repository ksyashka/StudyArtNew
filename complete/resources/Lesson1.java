import java.util.Objects;

/**
 * Created by Yuriy on 11.04.2017.
 */
public class Lesson1 {

    public static void main(String[] args) {
        User user = new User (1, "Ivan");
        int expected = 1;
        int actual = user.getId();
        System.out.printf("User id %s, expected %s, actual %s", Objects.equals (expected,actual), expected, actual);
        String expectedName = "Ivan";
        String actualname = user.getName();
        System.out.printf("User name %s, expected %s, actual %s", Objects.equals (expected,actual), expected, actual);

    }


    static class User{

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
