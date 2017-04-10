package utils.dynamic.core;

/**
 * Created by ksyashka on 10.04.2017.
 */
public interface ExecutionCore {
    String compile (String path);
    String execute (String compiledPath);

}
