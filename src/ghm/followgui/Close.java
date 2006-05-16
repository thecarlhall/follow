/* 
Copyright (C) 2000-2003 Greg Merrill (greghmerrill@yahoo.com)

This file is part of Follow (http://follow.sf.net).

Follow is free software; you can redistribute it and/or modify
it under the terms of version 2 of the GNU General Public
License as published by the Free Software Foundation.

Follow is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Follow; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package ghm.followgui;

import java.awt.event.ActionEvent;

/**
Action which closes the currently followed file.
@author <a href="mailto:greghmerrill@yahoo.com">Greg Merrill</a>
*/
class Close extends FollowAppAction {
  
  Close (FollowApp app) {
    super(
      app, 
      app.resBundle_.getString("action.Close.name"),
      app.resBundle_.getString("action.Close.mnemonic"),
      app.resBundle_.getString("action.Close.accelerator")
    );
  }

  public void actionPerformed (ActionEvent e) {
    FileFollowingPane fileFollowingPane = app_.getSelectedFileFollowingPane();
    int tab = app_.tabbedPane_.getSelectedIndex();
    if (tab >= 0) {
      app_.tabbedPane_.removeTabAt(tab);
      app_.disableDragAndDrop(fileFollowingPane.getTextArea());  
      app_.attributes_.removeFollowedFile(fileFollowingPane.getFollowedFile());
      fileFollowingPane.stopFollowing();
      app_.fileToFollowingPaneMap_.remove(fileFollowingPane.getFollowedFile());
      if (app_.fileToFollowingPaneMap_.size() == 0) {
        app_.close_.setEnabled(false);
        app_.top_.setEnabled(false);
        app_.bottom_.setEnabled(false);
        app_.clear_.setEnabled(false);
        app_.clearAll_.setEnabled(false);
        app_.delete_.setEnabled(false);
        app_.deleteAll_.setEnabled(false);
        app_.pause_.setEnabled(false);
      }
    }
  }

}
