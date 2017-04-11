package controller;

import exception.InvalidLessonPathException;
import model.Lesson;
import utils.dynamic.core.ExecuteCommandException;

/**
 * Created by Yuriy on 11.04.2017.
 */
public interface ILessonController {

    boolean checkLesson(String path) throws InvalidLessonPathException, ExecuteCommandException;

}
