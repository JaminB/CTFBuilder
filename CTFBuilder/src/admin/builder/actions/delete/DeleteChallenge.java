package admin.builder.actions.delete;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import utils.Delete;

import utils.ReadIn;
import utils.WriteOut;

public class DeleteChallenge {
	/**
	 * Provides methods for deleting challenges
	 * @author JaminB
	 */
	private String name;
	
	/**
	 * @param name name of challenge you wish to delete
	 */
	public DeleteChallenge(String name){
		this.name = name;
	}
	
	/**
	 * 
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @return true if delete successful; false otherwise
	 */
	public boolean delete(String compLoc, boolean smb) {
		String challengeLoc = compLoc + "/Challenges.ctf";
		ReadIn challenges = new ReadIn();
		WriteOut updated = new WriteOut();
		try{
                    ArrayList<String> fileData = challenges.read(challengeLoc, smb);
                    Delete delete = new Delete();
                    delete.delete(challengeLoc, smb);
                    for(int i = 0; i < fileData.size(); i++){
                            String[] splitLoc = fileData.get(i).split("\\|");
                            if(splitLoc[0].equals(name)){
                                    fileData.remove(i);
                            }
                            if(!fileData.isEmpty())
                                    updated.write(challengeLoc, fileData.get(i), smb);
                            else{
                                    updated.write(challengeLoc, "", smb);
                            }
                    }
                    return true;
                }catch(IOException e){
                    return false;
                }
	}
}
