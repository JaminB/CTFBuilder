package admin.builder.actions.delete;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import utils.ReadIn;
import utils.WriteOut;
import utils.Delete;

public class DeleteUser {
	/**
	 * @author JaminB
	 * Provides methods for deleting users
	 */
	private String username;
	
	/**
	 * @param username name of the user you wish to delete
	 */
	public DeleteUser(String username){
		this.username = username;
	}
	
	/**
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @throws IOException
	 */
	public void delete(String compLoc, boolean smb) throws IOException{
		purgeUserScore(compLoc,smb);
		purgeUserCompetitor(compLoc, smb);
		purgeUserChallengesCompleted(compLoc, smb);
		
	}
	
	private void purgeUserScore(String compLoc, boolean smb) throws IOException{
		String scoreLoc = compLoc + "/Scores.ctf";
		ReadIn fileData = new ReadIn();
		WriteOut updated = new WriteOut();
                System.out.println("score: " + scoreLoc);
		ArrayList<String> scores = fileData.read(scoreLoc, smb);
		Delete delete = new Delete();
		delete.delete(scoreLoc, smb);
		for(int i = 0; i < scores.size(); i++){
			if(scores.get(i).contains(username)){
				scores.set(i, "");
			}
			updated.write(scoreLoc, scores.get(i), smb);
		}
		
	}
	
	private void purgeUserCompetitor(String compLoc, boolean smb) throws IOException{
		String competiterLoc = compLoc + "/Users.ctf";
		ReadIn fileData = new ReadIn();
		WriteOut updated = new WriteOut();
		ArrayList<String> users = fileData.read(competiterLoc, smb);
		Delete delete = new Delete();
		delete.delete(competiterLoc, smb);
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).contains(username)){
				users.set(i, "");
			}
			updated.write(competiterLoc, users.get(i), smb);
		}
	}
	
	private void purgeUserChallengesCompleted(String compLoc, boolean smb) throws IOException{
		String challengeCompletedLoc = compLoc + "/Challenges_Completed.ctf";
		ReadIn fileData = new ReadIn();
		WriteOut updated = new WriteOut();
		ArrayList<String> challenges = fileData.read(challengeCompletedLoc, smb);
		Delete delete = new Delete();
		delete.delete(challengeCompletedLoc, smb);
		for(int i = 0; i < challenges.size(); i++){
			if(challenges.get(i).contains(username)){
				challenges.set(i, "");
			}
			updated.write(challengeCompletedLoc, challenges.get(i), smb);
		}
	}
}
