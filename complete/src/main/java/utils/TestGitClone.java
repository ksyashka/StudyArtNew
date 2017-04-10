package utils;

import org.eclipse.jgit.api.errors.GitAPIException;

/**
 * Created by ksyashka on 10.04.2017.
 */
public class TestGitClone {
    public static void main(String[] args) throws GitAPIException {
        GitClone.cloneRepository("https://github.com/ksyashka/ACP17","C:\\Users\\ksyashka\\IdeaProjects\\clone");
    }
}
