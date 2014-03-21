package admin.builder.actions.update;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import utils.Delete;


public class UpdateChallenge {
	/**
	 * @author JaminB
	 * Provides methods for manipulating existing challenges
	 */
	private String name;
	/**
	 * @param name the name of the challenge to update
	 */
	public UpdateChallenge(String name){
		this.name = name;
	}
	
	/**
	 * Update the name of a challenge
	 * @param newName name to change your challenge to
	 * @param compLoc location of your competition
	 * @param smb true if we are using a remote path
	 * @throws IOException
	 */
	public void updateName(String newName, String compLoc, boolean smb) throws IOException{
		utils.WriteOut updated = new utils.WriteOut();
		ArrayList<String> fileData = prepFile(compLoc, smb);
		for(int i = 0; i < fileData.size(); i++){
			String[] splitLoc = fileData.get(i).split("\\|");
			if(splitLoc[0].equals(name)){
				fileData.set(i, newName + "|" + splitLoc[1] + "|"+ splitLoc[2] + "|" + splitLoc[3]);
			}
			updated.write(compLoc + "/Challenges.ctf", fileData.get(i), smb);
		}
	}
	/**
	 * @param newFlag new flag value
	 * @param compLoc location of your competition
	 * @param smb true if we are using a remote path
	 * @throws IOException
	 */
	public void updateFlag(String newFlag, String compLoc, boolean smb) throws IOException{
		utils.WriteOut updated = new utils.WriteOut();
		ArrayList<String> fileData = prepFile(compLoc, smb);
		for(int i = 0; i < fileData.size(); i++){
			String[] splitLoc = fileData.get(i).split("\\|");
			if(splitLoc[0].equals(name)){
				fileData.set(i, splitLoc[0] + "|" + newFlag + "|"+ splitLoc[2] + "|" + splitLoc[3]);
			}
			updated.write(compLoc + "/Challenges.ctf", fileData.get(i), smb);
		}
	}
	/**
	 * @param newDescription new description value
	 * @param compLoc location of your competition
	 * @param smb true if we are using a remote path
	 * @throws IOException
	 */
	public void updateDescription(String newDescription, String compLoc, boolean smb) throws IOException{
		utils.WriteOut updated = new utils.WriteOut();
		ArrayList<String> fileData = prepFile(compLoc, smb);
		for(int i = 0; i < fileData.size(); i++){
			String[] splitLoc = fileData.get(i).split("\\|");
			if(splitLoc[0].equals(name)){
				fileData.set(i, splitLoc[0] + "|" + splitLoc[1] + "|"+ newDescription + "|" + splitLoc[3]);
			}
			updated.write(compLoc + "/Challenges.ctf", fileData.get(i), smb);
		}
	}
	
	/**
	 * @param newScore new score value
	 * @param compLoc location of your competition
	 * @param smb true if we are using a remote path
	 * @throws IOException
	 */
	public void updateValue(int newScore, String compLoc, boolean smb) throws IOException{
		utils.WriteOut updated = new utils.WriteOut();
		ArrayList<String> fileData = prepFile(compLoc, smb);
		for(int i = 0; i < fileData.size(); i++){
			String[] splitLoc = fileData.get(i).split("\\|");
			if(splitLoc[0].equals(name)){
				fileData.set(i, splitLoc[0] + "|" + splitLoc[1] + "|"+ splitLoc[2] + "|" + newScore);
			}
			updated.write(compLoc + "/Challenges.ctf", fileData.get(i), smb);
		}
	}
	
	private ArrayList<String> prepFile(String compLoc, boolean smb) throws IOException{
		utils.ReadIn challengeFile = new utils.ReadIn();
		ArrayList<String> fileData = challengeFile.read(compLoc + "/Challenges.ctf", smb);
		new Delete().delete(compLoc + "/Challenges.ctf", smb);
		return fileData;
	}
	
}
