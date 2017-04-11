package mockitotest;

import controller.ILessonController;
import controller.LessonControllerImpl;
import exception.InvalidLessonPathException;
import org.mockito.Mockito;
import utils.BashImpl;
import utils.IBash;
import utils.dynamic.core.ExecuteCommandException;
import utils.dynamic.core.ExecutionCore;
import utils.dynamic.core.ExecutionCoreImpl;

/**
 * Created by ksyashka on 11.04.2017.
 */
public class TestMockController {
    private static final String LESSON_PATH = "C:/Users/ksyashka/IdeaProjects/StudyArtNew/complete/resources/Lesson1.java" ;

    public static void main(String[] args) {
        IBash bash = Mockito.mock(BashImpl.class);
        ExecutionCore executionCore = new ExecutionCoreImpl(bash);
        ILessonController lessonController = new LessonControllerImpl(executionCore);
        try {
            lessonController.checkLesson(LESSON_PATH);
        } catch (InvalidLessonPathException e) {
            e.printStackTrace();
        } catch (ExecuteCommandException e) {
            e.printStackTrace();
        }
    }

}
