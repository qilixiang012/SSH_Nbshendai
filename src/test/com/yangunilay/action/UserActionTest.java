package com.yangunilay.action;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * UserAction Tester.
 *
 * @author <Authors name>
 * @since <pre>10/30/2013</pre>
 * @version 1.0
 */
public class UserActionTest extends TestCase {
    public UserActionTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(UserActionTest.class);
    }
}
