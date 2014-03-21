package admin.builder.actions.create;

import java.io.IOException;
import utils.NewOps;

public class CreateComp {
	/**
	 * @author JaminB
	 * Provides methods for creating new competitions
	 */
	/**
	 * 
	 * @param directoryOfCreation the exact path to the directory that the competition will be created in
	 * @param competitionName the name of your competition
	 * @param smb true if using a remote path
	 * @throws IOException
	 */
	public void create(String directoryOfCreation, String competitionName, boolean smb) throws IOException{
		NewOps create = new NewOps();
		create.newDirectory(directoryOfCreation + competitionName, smb);
                System.out.println("results: " + smb+ " " +  directoryOfCreation + competitionName);
		create.newFile(directoryOfCreation + competitionName + "/Users.ctf", smb);
		create.newFile(directoryOfCreation + competitionName + "/Challenges.ctf", smb);
		create.newFile(directoryOfCreation + competitionName + "/Scores.ctf", smb);
	}
}
