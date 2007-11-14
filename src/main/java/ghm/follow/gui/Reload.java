/*
 * Copyright (C) 2000-2003 Greg Merrill (greghmerrill@yahoo.com)
 * 
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

package ghm.follow.gui;

import ghm.follow.FollowApp;

import java.awt.event.ActionEvent;

/**
 * Action which closes the currently followed file.
 * 
 * @author <a href="mailto:greghmerrill@yahoo.com">Greg Merrill</a>
 */
public class Reload extends FollowAppAction {
	public static final String NAME = "reload";

	public Reload(FollowApp app) {
		super(app, FollowApp.getResourceBundle().getString("action.Reload.name"), FollowApp.getResourceBundle()
				.getString("action.Reload.mnemonic"), FollowApp.getResourceBundle().getString(
				"action.Reload.accelerator"));
	}

	public void actionPerformed(ActionEvent e) {
		FileFollowingPane fileFollowingPane = getApp().getSelectedFileFollowingPane();
		fileFollowingPane.restartFollowing();
	}
}