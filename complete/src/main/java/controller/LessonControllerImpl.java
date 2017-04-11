package controller;

import exception.InvalidLessonPathException;
import utils.dynamic.core.ExecuteCommandException;
import utils.dynamic.core.ExecutionCore;
import utils.dynamic.core.ExecutionCoreImpl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * Created by Yuriy on 11.04.2017.
 */
public class LessonControllerImpl implements ILessonController {
    ExecutionCore executionCore;

    public LessonControllerImpl(ExecutionCore executionCore) {
        this.executionCore = executionCore;
    }

    @Override
    public boolean checkLesson(String path) throws InvalidLessonPathException {
        if (!Files.exists(Paths.get(path))) {
            throw new InvalidLessonPathException("no lesson with path " + path);
        }
        String compiledPath = executionCore.compile(path);
        try {
            String result = executionCore.execute(compiledPath);
            return true;
        } catch (ExecuteCommandException e){
            e.printStackTrace();
        }
        return false;
    }
}
