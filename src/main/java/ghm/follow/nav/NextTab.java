/*
 * This file is part of Follow (http://follow.sf.net).
 * 
 * Follow is free software; you can redistribute it and/or modify it under the
 * terms of version 2 of the GNU General Public License as published by the Free
 * Software Foundation.
 * 
 * Follow is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * Follow; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA 02111-1307 USA
 */
package ghm.follow.nav;

import ghm.follow.gui.FollowApp;
import ghm.follow.gui.FollowAppAction;

import java.awt.event.ActionEvent;

/**
 * Switches to the next tab in the frame.
 * 
 * @author <a href="mailto:chall@cfhdev.com">Carl Hall</a>
 */
public class NextTab extends FollowAppAction {
	public static final String NAME = "nextTab";

	public NextTab(FollowApp app) {
		super(app, FollowApp.getResourceBundle().getString("action.NextFile.name"), FollowApp
				.getResourceBundle().getString("action.NextFile.mnemonic"), FollowApp.getResourceBundle()
				.getString("action.NextFile.accelerator"), FollowApp.getResourceBundle().getString(
				"action.NextFile.icon"));
	}

	/**
	 * Moves to next tab if not at the last tab.
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		int currentIndex = getApp().getTabbedPane().getSelectedIndex();
		if (currentIndex < getApp().getTabbedPane().getTabCount() - 1) {
			getApp().getTabbedPane().setSelectedIndex(currentIndex + 1);
		}
	}
}