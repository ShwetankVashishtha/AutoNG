package hooks;

import base.TestBase;
import io.cucumber.java.After;

public class Contexts {

    TestBase testBase = new TestBase();

    @After
    public void shutdownSession() {
        testBase.closeActiveSessions();
    }
}
