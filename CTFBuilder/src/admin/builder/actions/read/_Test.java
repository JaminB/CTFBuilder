package admin.builder.actions.read;

import java.io.IOException;

public class _Test {

	public static void main(String[] args) throws IOException {
		ReadUsers user1 = new ReadUsers();
		//System.out.println(user1.FetchAllUsers());
		//System.out.println(user1.checkExists());
		//System.out.println(user1.Search(""));
		String creationDirectory = "/home/jamin/Comp2";
		String smbDirectory = "smb://107.170.39.131/ctf/";
		ReadChallenges readChallenge = new ReadChallenges();
                ReadUsers readUsers = new ReadUsers();
		//System.out.println(readChallenge.FetchAllChallenges(creationDirectory, false));
		//System.out.println(readChallenge.FetchAllDescriptions(creationDirectory, false));
		//System.out.println(readChallenge.FetchAllFlags(creationDirectory, false));
		//System.out.println(readChallenge.FetchAllNames(creationDirectory, false));
		//System.out.println(readChallenge.FetchAllValues(creationDirectory,false));
		//System.out.println(readChallenge.GetValues("awesome-challenge", creationDirectory, false));
		//System.out.println(readChallenge.Search("ja",creationDirectory, false));
		//System.out.println(user1.GetScore("reilly",creationDirectory, false));
		//System.out.println(user1.GetCompletedChallenges("reilly",creationDirectory, false));
         System.out.println(readUsers.Search("j", creationDirectory, false));
	}

}
