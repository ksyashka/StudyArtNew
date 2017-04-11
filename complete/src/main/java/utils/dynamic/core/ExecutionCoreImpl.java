package utils.dynamic.core;

import utils.IBash;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by ksyashka on 10.04.2017.
 */
public class ExecutionCoreImpl implements ExecutionCore {
    private IBash bash;

    public ExecutionCoreImpl(IBash bash) {
        this.bash = bash;
    }

    @Override
    public String compile(String path) {
        try {
            String result = bash.executeCommand("javac", path);
            System.out.println("Compilation result: " + result);
            String newPath = path.replace(".java", ".class");
            return newPath;
        } catch (ExecuteCommandException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String execute(String compiledPath) throws ExecuteCommandException {
        Class cl = ExecutionCoreImpl.class;

        try {
            File root = new File(compiledPath.substring(0, compiledPath.lastIndexOf("/")));
            File compiled = new File(compiledPath);

            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{root.toURI().toURL()});
            String className = compiledPath.substring(compiledPath.lastIndexOf('/') + 1, compiledPath.lastIndexOf('.'));

            Class<?> cls = Class.forName(className, true, classLoader); // Should print "hello".

            Method mainRunMethod = cls.getMethod("main",String[].class);
            String[] params = null;
            mainRunMethod.invoke(null,(Object)params);
            return "success execution";

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        throw new ExecuteCommandException("some problem");
    }
}
