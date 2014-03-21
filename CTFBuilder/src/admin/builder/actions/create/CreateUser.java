package admin.builder.actions.create;

import java.io.IOException;

import utils.*;

public class CreateUser {
	/**
	 * @author JaminB
	 * Provides methods for creating a new user
	 */
	private String username;
	
	/**
	 * @param username desired name of user
	 */
	public CreateUser(String username){
		this.username = username;
	}
	
	/**
	 * 
	 * @param score starting score of user
	 * @param compLoc location of competition
	 * @param smb true if using a remote path
	 * @throws IOException
	 */
	public void create(String score, String compLoc, boolean smb) throws IOException{
		String scoreLoc = compLoc + "/Scores.ctf";
		String competiterLoc = compLoc + "/Users.ctf";
		String challengeCompletedLoc = compLoc + "/Challenges_Completed.ctf";
		utils.WriteOut scores = new utils.WriteOut();
		utils.WriteOut competiters = new utils.WriteOut();
		utils.WriteOut challengesCompleted = new WriteOut();
		scores.write(scoreLoc, username + "|" + score, smb);
		competiters.write(competiterLoc, username, smb);
		challengesCompleted.write(challengeCompletedLoc, username + "|", smb);
	}
}
