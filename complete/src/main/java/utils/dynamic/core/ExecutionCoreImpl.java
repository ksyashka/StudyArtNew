package utils.dynamic.core;

import utils.IBash;

import java.io.File;
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
    public String execute(String compiledPath) {
        Class cl = ExecutionCoreImpl.class;

        try{
            File root = new File(compiledPath);
            File sourceFile = new File(compiledPath);
            //01:53
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
            Class<?> cls = Class.forName("test.Test", true, classLoader); // Should print "hello".
            Object instance = cls.newInstance(); // Should print "world".

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }
}
