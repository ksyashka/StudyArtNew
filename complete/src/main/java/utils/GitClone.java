package utils;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.File;

/**
 * Created by ksyashka on 10.04.2017.
 */
public class GitClone {
    public static void cloneRepository(String url, String directoryPath) throws GitAPIException {
        Git git = Git.cloneRepository()
                .setURI(url)
                .setDirectory(new File(directoryPath))
                .call();
    }
}
