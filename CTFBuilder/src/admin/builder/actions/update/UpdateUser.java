package admin.builder.actions.update;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import utils.*;

public class UpdateUser {
	/**
	 * Provides methods for updating a users name
	 * @author JaminB
	 */
	private String username;
	private String newUsername;
	
	/**
	 * @param username current username
	 * @param newUsername new username
	 */
	public UpdateUser(String username, String newUsername){
		this.username = username;
		this.newUsername = newUsername;
	}
        
	
	/**
	 * Updates the users name
	 * @param compLoc location of the competition
	 * @param smb true if we are using a remote path
	 * @throws IOException
	 */
	public void update(String compLoc, boolean smb) throws IOException{
		updateUsersFile(compLoc, smb);
		updateScoresFile(compLoc, smb);
        updateCompletedChallengesFile(compLoc, smb);
	}
	
	private void updateUsersFile(String compLoc, boolean smb) throws IOException{
		String userLoc = compLoc + "/Users.ctf";
		ReadIn users = new ReadIn();
		WriteOut updatedUsers = new WriteOut();
		ArrayList<String> replaced = userFindReplace(users.read(userLoc, smb));
		new Delete().delete(userLoc, smb);
		for(int i = 0; i < replaced.size(); i++){
			updatedUsers.write(userLoc, replaced.get(i), smb);
		}
		
	}
	
	private void updateScoresFile(String compLoc, boolean smb) throws IOException{
		String scoreLoc = compLoc + "/Scores.ctf";
		ReadIn users = new ReadIn();
		WriteOut updatedUsers = new WriteOut();
		ArrayList<String> replaced = userFindReplace(users.read(scoreLoc, smb));
		new Delete().delete(scoreLoc, smb);
		for(int i = 0; i < replaced.size(); i++){
			updatedUsers.write(scoreLoc, replaced.get(i), smb);
		}
	}
        private void updateCompletedChallengesFile(String compLoc, boolean smb) throws IOException{
		String chalCmpLoc = compLoc + "/Challenges_Completed.ctf";
		ReadIn users = new ReadIn();
		WriteOut updatedUsers = new WriteOut();
		ArrayList<String> replaced = userFindReplace(users.read(chalCmpLoc, smb));
		new Delete().delete(chalCmpLoc, smb);
		for(int i = 0; i < replaced.size(); i++){
			updatedUsers.write(chalCmpLoc, replaced.get(i), smb);
		}
	}
	
	private ArrayList<String> userFindReplace(ArrayList<String> userLocContents){
		for(int i = 0; i < userLocContents.size(); i++){
			if(userLocContents.get(i).contains(username)){
				String replacement = userLocContents.get(i).replace(username, newUsername);
				userLocContents.set(i, replacement);
			}
		}
		return userLocContents;
	}
}
