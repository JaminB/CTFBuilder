package admin.builder.actions.update;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import utils.Delete;
import utils.ReadIn;
import utils.WriteOut;



public class UpdateCompletedChallenge {
	/**
	 * Provides methods for updating challenges completed by users
	 * @author JaminB
	 */
	private String username;
	private String challengeName;
	
	/**
	 * Mark a challenge completed for a specific user
	 * @param username the user who has completed the challenge
	 * @param challengeName the challenge to mark completed by user
	 */
	public UpdateCompletedChallenge(String username, String challengeName){
		this.username = username;
		this.challengeName = challengeName;
	}
	/**
	 * 
	 * @param compLoc location of the competition
	 * @param smb true if we are using a remote path
	 * @throws IOException
	 */
	public void update(String compLoc, boolean smb) throws IOException{
		String challengesCompletedLoc = compLoc + "/Challenges_Completed.ctf";
		ReadIn challengesCompletedFile = new ReadIn();
		ArrayList<String> challengesCompleted = challengesCompletedFile.read(challengesCompletedLoc, smb);
		WriteOut updatedChallengesCompleted = new WriteOut();
		new Delete().delete(challengesCompletedLoc, smb);
		for(int i = 0; i < challengesCompleted.size(); i++){
			if(challengesCompleted.get(i).indexOf(username) == 0){
				if(!challengesCompleted.get(i).contains(challengeName)){
					challengesCompleted.set(i, challengesCompleted.get(i) + challengeName + "|");
				}
			}
			updatedChallengesCompleted.write(challengesCompletedLoc, challengesCompleted.get(i), smb);
		}
	}
}
