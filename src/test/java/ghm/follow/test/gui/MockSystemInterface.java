package ghm.follow.test.gui;

import ghm.follow.systemInterface.SystemInterface;

import java.io.File;

public class MockSystemInterface implements SystemInterface {
	private File[] filesFromUser;
	private boolean exitCalled;

	public File[] getFilesFromUser() {
		return filesFromUser;
	}

	public void setFilesFromUser(File[] file) {
		filesFromUser = file;
	}

	public void exit(int code) {
		exitCalled = true;
	}

	public boolean exitCalled() {
		return exitCalled;
	}

	public void reset() {
		exitCalled = false;
	}
}