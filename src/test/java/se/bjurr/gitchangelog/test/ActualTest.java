package se.bjurr.gitchangelog.test;

import static se.bjurr.gitchangelog.api.GitChangelogApi.gitChangelogApiBuilder;

import java.io.File;
import java.util.logging.Logger;

import org.junit.Test;

public class ActualTest {
 /**
  * The actual repo to test!
  */
 private static final String GIT_REPO_DIR = "/home/bjerre/workspace/git-changelog-lib";
 private static final Logger LOG = Logger.getLogger(ActualTest.class.getSimpleName());

 @Test
 public void testThatGimmitsBetweenTagsCanBeFound() throws Exception {
  File file = new File(GIT_REPO_DIR);
  if (!file.exists()) {
   LOG.info("Did not find " + GIT_REPO_DIR + " will not run test.");
   return;
  }

  String changelogString = gitChangelogApiBuilder()//
    .withFromRepo(GIT_REPO_DIR)//
    .withFromCommit("191fc35")//
    .withToCommit("7ae6a94")//
    .withTemplateContent("{{#commits}}{{hash}} {{messageTitle}}\n\n{{/commits}}")//
    .render();

  LOG.info(changelogString);
 }
}
