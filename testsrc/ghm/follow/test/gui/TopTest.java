package ghm.follow.test.gui;

import ghm.follow.nav.Top;

public class TopTest extends AppLaunchingTestCase {

	public TopTest(String name) {
		super(name);
	}

	public void testTop() {
		assertEquals(false, app_.getAction(Top.NAME).isEnabled());
	}

}