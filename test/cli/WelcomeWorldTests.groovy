import grails.test.AbstractCliTestCase

class WelcomeWorldTests extends AbstractCliTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testWelcomeWorld() {

        execute(["welcome-world"])

        assertEquals 0, waitForProcess()
        verifyHeader()
    }
}
