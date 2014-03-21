package admin.builder.actions.update;

import java.io.IOException;

public class _Test {

	public static void main(String[] args) throws IOException {
		String creationDirectory = "/home/jamin/PlainText";
		UpdateUser myUserUpdate = new UpdateUser("jamin", "reilly");
		myUserUpdate.update(creationDirectory, false);
		//UpdateChallenge challengeUpdater = new UpdateChallenge("challenge2");
		//challengeUpdater.updateValue(300, creationDirectory);
		//CompletedChallenge completedUpdater = new CompletedChallenge("jack","challenge1");
		//completedUpdater.update();
		

	}

}
