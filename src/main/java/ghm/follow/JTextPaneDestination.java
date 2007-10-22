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

package ghm.follow;

import org.apache.log4j.Logger;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

/**
 * Implementation of {@link OutputDestination} which appends Strings to a
 * {@link JTextPane}.
 * 
 * @see OutputDestination
 * @see JTextPane
 * @author <a href="mailto:carl.hall@gmail.com">Carl Hall</a>
 */
public class JTextPaneDestination implements OutputDestination {

	/**
	 * Construct a new JTextPaneDestination.
	 * 
	 * @param jTextPane
	 *            text will be appended to this text area
	 * @param autoPositionCaret
	 *            if true, caret will be automatically moved to the bottom of
	 *            the text area when text is appended
	 */
	public JTextPaneDestination(JTextPane jTextPane, boolean autoPositionCaret) {
		jTextPane_ = jTextPane;
		autoPositionCaret_ = autoPositionCaret;
	}

	public JTextPane getJTextPane() {
		return jTextPane_;
	}

	public void setJTextArea(JTextPane jTextPane) {
		jTextPane_ = jTextPane;
	}

	/**
	 * Add a filtered view to this destination. Filtered views show only a
	 * subset of the total output based on filter conditions.
	 * 
	 * @since 1.8.0
	 */
	public void addFilteredView() {

	}

	/**
	 * Remove a filtered view
	 * 
	 * @since 1.8.0
	 */
	public void removeFilteredView() {

	}

	/**
	 * @return whether caret will be automatically moved to the bottom of the
	 *         text area when text is appended
	 */
	public boolean autoPositionCaret() {
		return autoPositionCaret_;
	}

	/**
	 * @param autoPositionCaret
	 *            if true, caret will be automatically moved to the bottom of
	 *            the text area when text is appended
	 */
	public void setAutoPositionCaret(boolean autoPositionCaret) {
		autoPositionCaret_ = autoPositionCaret;
	}

	public void print(String s) {
		try {
			jTextPane_.getDocument().insertString(jTextPane_.getDocument().getLength(), s, null);
			if (autoPositionCaret_) {
				jTextPane_.setCaretPosition(jTextPane_.getDocument().getLength());
			}
		}
		catch (BadLocationException e) {
			// just ignore, nothing we can do
			getLog().error("BadLocationException in JTextPaneDestination", e);
		}
	}

	public void clear() {
		jTextPane_.setText("");
		if (autoPositionCaret_) {
			jTextPane_.setCaretPosition(0);
		}
	}

	private transient Logger log;

	private Logger getLog() {
		if (log == null) {
			log = Logger.getLogger(JTextPaneDestination.class.getName());
		}
		return log;
	}

	protected JTextPane jTextPane_;

	protected boolean autoPositionCaret_;

}