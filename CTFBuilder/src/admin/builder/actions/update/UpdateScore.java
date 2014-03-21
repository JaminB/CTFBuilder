package admin.builder.actions.update;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import utils.*;

public class UpdateScore {
	/**
	 * Provides methods to update a users score
	 * @author JaminB
	 */
	private String username;
	private int pointsToAdd;
	
	/**
	 * @param username 
	 * @param pointsToAdd
	 */
	public UpdateScore(String username, int pointsToAdd){
		this.username = username;
		this.pointsToAdd = pointsToAdd;
	}
	/**
	 * Adds the score to the current score
	 * @param compLoc location of the competition
	 * @param smb true if we are using a remote path
	 * @throws IOException
	 */
	public void updateAdd(String compLoc, boolean smb) throws IOException{
		String scoreLoc = compLoc + "/Scores.ctf";
		ReadIn users = new ReadIn();
		WriteOut updatedScore = new WriteOut();
		ArrayList<String> scoreLocContents = users.read(scoreLoc, smb);
		new Delete().delete(scoreLoc, smb);
		for(int i = 0; i < scoreLocContents.size(); i++){
			String[] splitLoc = scoreLocContents.get(i).split("\\|");
			if(splitLoc[0].equals(username)){
				int score = Integer.parseInt(splitLoc[1]) + pointsToAdd;
				scoreLocContents.set(i, username + "|" + score);
			}
			updatedScore.write(scoreLoc, scoreLocContents.get(i), smb);
		}
	}
		/**
		 * Replace the score with the current score
		 * @param compLoc location of the competition
		 * @param smb true if we are using a remote path
		 * @throws IOException
		 */
        public void updateReplace(String compLoc, boolean smb) throws IOException{
            String scoreLoc = compLoc + "/Scores.ctf";
			ReadIn users = new ReadIn();
			WriteOut updatedScore = new WriteOut();
			ArrayList<String> scoreLocContents = users.read(scoreLoc, smb);
			new Delete().delete(scoreLoc, smb);
			for(int i = 0; i < scoreLocContents.size(); i++){
				String[] splitLoc = scoreLocContents.get(i).split("\\|");
				if(splitLoc[0].equals(username)){
					int score = pointsToAdd;
					scoreLocContents.set(i, username + "|" + score);
				}
				updatedScore.write(scoreLoc, scoreLocContents.get(i), smb);
			}
        }
}
