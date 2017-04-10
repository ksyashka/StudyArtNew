package utils;

import utils.dynamic.core.ExecuteCommandException;

/**
 * Created by ksyashka on 10.04.2017.
 */
public interface IBash {
    String executeCommand(String command, String...args) throws ExecuteCommandException;
}
