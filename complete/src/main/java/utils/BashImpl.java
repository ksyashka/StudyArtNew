package utils;

import utils.dynamic.core.ExecuteCommandException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Created by ksyashka on 10.04.2017.
 */
public class BashImpl implements IBash {
    @Override
    public String executeCommand(String command, String... args) throws ExecuteCommandException {
        String formattedArg = String.join(" ", args);
        String formattedCommand = String.format("%s %s", command, formattedArg);
        try {
            Process process = Runtime.getRuntime().exec(formattedCommand);
            process.waitFor();

            int resultCode = process.exitValue();

            String result = IOUtils.readAll(process.getInputStream());
            String error = IOUtils.readAll(process.getErrorStream());

            if (resultCode != 0 || !error.isEmpty()){
                throw new ExecuteCommandException(error);
            }
            return result;
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

   }
