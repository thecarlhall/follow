package ghm.follow.test.gui;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ghm.follow.gui.Close;
import ghm.follow.gui.Open;
import ghm.follow.nav.Bottom;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BottomT extends AppLaunchingTestCase {
	@BeforeClass
	public static void beforeClass() throws Exception {
		AppLaunchingTestCase.launch(null);
	}

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		AppLaunchingTestCase.shutdown();
	}

	@Test
	public void testEnabled() throws Exception {
		assertFalse(app.getAction(Bottom.NAME).isEnabled());
		File[] file = new File[] { createTempFile() };
		systemInterface.setFilesFromUser(file);
		invokeAction(app.getAction(Open.NAME));
		assertTrue(app.getAction(Bottom.NAME).isEnabled());
		invokeAction(app.getAction(Close.NAME));
		assertFalse(app.getAction(Bottom.NAME).isEnabled());
	}
}