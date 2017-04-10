package utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Created by ksyashka on 10.04.2017.
 */
public class IOUtils {
    public static String readAll(InputStream is) {
        BufferedReader bis = new BufferedReader(new InputStreamReader(is));
        return bis.lines().collect(Collectors.joining("/n"));
    }

}
