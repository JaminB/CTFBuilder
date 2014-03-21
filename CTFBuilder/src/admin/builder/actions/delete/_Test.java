package admin.builder.actions.delete;

import java.io.IOException;

public class _Test {

	public static void main(String[] args) throws IOException {
		String createDirectory = "/home/jamin/myCmp";
		//Comp admin = new Comp();
		//admin.delete(createDirectory);
		DeleteChallenge challengeDelete = new DeleteChallenge("jamins-challenge");
		challengeDelete.delete(createDirectory, false);
		//User admin = new User("reilly");
		//admin.delete(createDirectory);
		

	}
}
