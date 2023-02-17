package units;

import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * @author shwetankvashishtha
 */

public class JiraIntegration {

    @Mock
    Issue issue;

    @Test
    public void testGetIssue() throws JiraException {
        JiraClient jiraClient = Mockito.mock(JiraClient.class);
        Mockito.mock(Issue.class);
        Mockito.when(jiraClient.getIssue(Matchers.any(String.class))).thenReturn(issue);
        Assert.assertEquals(jiraClient.getIssue(Matchers.any(String.class)), issue);
    }
}
