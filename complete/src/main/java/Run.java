import controller.ILessonController;
import controller.LessonControllerImpl;
import exception.InvalidLessonPathException;
import org.eclipse.jgit.api.errors.GitAPIException;
import utils.BashImpl;
import utils.GitClone;
import utils.dynamic.core.ExecuteCommandException;
import utils.dynamic.core.ExecutionCore;
import utils.dynamic.core.ExecutionCoreImpl;

/**
 * Created by Yuriy on 11.04.2017.
 */
public class Run {
    private static final String LESSON_PATH = "C:/Users/Yuriy/IdeaProjects/StudyArtNew/complete/resources/Lesson1.java" ;

    public static void main(String[] args) {
        ExecutionCore executionCore = new ExecutionCoreImpl(new BashImpl());
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
