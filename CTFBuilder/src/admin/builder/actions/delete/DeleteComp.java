package admin.builder.actions.delete;

import java.io.File;
import java.io.IOException;

import jcifs.smb.SmbFile;

import org.apache.commons.io.FileUtils;

public class DeleteComp {
	/**
	 * Provides methods for deleting a competition
	 * @author JaminB
	 */
	
	/**
	 * 
	 * @param compLoc location of competition
	 * @param smb true if we are using a remote path
	 * @return true if delete successful; false otherwise
	 * @throws IOException
	 */
	public boolean delete(String compLoc, boolean smb) throws IOException{
		System.out.println(compLoc);
		boolean exists = false;
			if(smb){
                File checkExists = new File(compLoc + "/Users.ctf");
                exists = checkExists.exists();
			}
			else{
				SmbFile checkExists = new SmbFile(compLoc + "/Users.ctf");
				exists = checkExists.exists();
			}
		if(exists){
                    FileUtils.deleteDirectory(new File(compLoc));
                    return true;
                }
                return false;
                
	}
}
