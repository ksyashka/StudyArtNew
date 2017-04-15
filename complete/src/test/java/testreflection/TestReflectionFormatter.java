package testreflection;

import org.junit.*;
import org.junit.runners.MethodSorters;

/**
 * Created by Yuriy on 12.04.2017.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestReflectionFormatter {

    private ReflectionFormatter formatter = new ReflectionFormatter();

    private static Robot robot;
    private static String robotStr;

    @BeforeClass
    public static void beforeClass() {
        robot = new Robot(1, "DDRW2", 10000.0);

        robotStr = String.format("type:%s\nid:%s\nmodel:%s\nprice:%s\n",
                robot.getClass().getName(),
                robot.getId(),
                robot.getModel(),
                robot.getPrice());
    }

    @Test
    public void _01testFormat() {
        String res = formatter.format(robot);
        Assert.assertEquals(robotStr, res);
    }

    @Test
    public void _02testParse() {
        Object obj = formatter.parse(robotStr);
        Assert.assertEquals(robot, obj);
    }

}
