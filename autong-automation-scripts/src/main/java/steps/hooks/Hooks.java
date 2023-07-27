package steps.hooks;

import base.TestBase;
import io.cucumber.java.*;

public class Hooks {

    TestBase testBase = new TestBase();
    static int pass, fail, skip;

    @Before
    public void testInitiator() {
    }

    @BeforeAll
    public static void setup() {
    }

    @After
    public void testClosure(Scenario scenario) {
        Status status = scenario.getStatus();
        if (status.equals(Status.PASSED)) {
            pass++;
        } else if (status.equals(Status.FAILED)) {
            fail++;
        } else if (status.equals(Status.SKIPPED)) {
            skip++;
        }
        testBase.closeCurrentSession();
    }

    @AfterAll
    public static void tearDown() {
    }
}
