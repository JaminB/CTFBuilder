package admin.builder.actions.create;

import java.io.IOException;



public class _Test {

	public static void main(String[] args) throws IOException {
		CreateComp comp = new CreateComp();
		comp.create("/home/jamin/", "myCmp", false);
		String createDirectory = "/home/jamin/myCmp";
		CreateUser user1 = new CreateUser("reilly");
		CreateUser user2 = new CreateUser("jamin");
		CreateUser user3 = new CreateUser("kyle");
		CreateUser user4 = new CreateUser("jack");
		CreateChallenge challenge1 = new CreateChallenge("jamins-challenge", "12345","cool challenge", 9001);
		CreateChallenge challenge2 = new CreateChallenge("challenge2", "12345","cool challenge 2", 50);
		user1.create("50", createDirectory, false);
		user2.create("200", createDirectory, false);
		user3.create("300", createDirectory, false);
		user4.create("400", createDirectory, false);
		challenge1.create(createDirectory, false);
		challenge2.create(createDirectory, false);
		//challenge2.create();
		
	}	

}
