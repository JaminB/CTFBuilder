package admin.builder.actions.create;

import java.io.IOException;

public class CreateChallenge {
	/**
	 * @author JaminB
	 * Provides methods for creating new challenges
	 */
	private String challengeName;
	private String challengeFlag;
	private String challengeDescription;
	private int scoreValue;
	/**
	 * 
	 * @param challengeName name of challenge
	 * @param challengeFlag flag for challenge
	 * @param challengeDescription description of challenge
	 * @param scoreValue value of challenge
	 */
	public CreateChallenge(String challengeName, String challengeFlag, String challengeDescription, int scoreValue){
		this.challengeName = challengeName;
		this.challengeFlag = challengeFlag;
		this.challengeDescription = challengeDescription;
		this.scoreValue = scoreValue;
	}
	
	/**
	 * 
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @throws IOException
	 */
	public void create(String compLoc, boolean smb) throws IOException{
		utils.WriteOut challenges = new utils.WriteOut();
		challenges.write(compLoc + "/Challenges.ctf", this.challengeName +  "|" + this.challengeFlag + "|" + this.challengeDescription + "|" + this.scoreValue, smb);
	}
}
