package utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;

public class NewOps {
	
	public void newFile(String fileLocation) throws IOException{
		File file = new File(fileLocation);
		file.createNewFile();
	}
	
	public void newFile(String smbLocation, boolean smb) throws IOException{
		if(smb){
			SmbFile smbFile = new SmbFile(smbLocation);
			smbFile.createNewFile();
		}
		else{
			newFile(smbLocation);
		}
	}
	
	public void newDirectory(String fileLocation) throws IOException{
		File file = new File(fileLocation);
		file.mkdir();
	}
	
	public void newDirectory(String smbLocation, boolean smb) throws IOException{
		if(smb){
			SmbFile smbFile = new SmbFile(smbLocation);
                        System.out.println("Test: " + smbLocation);
			smbFile.mkdir();
		}
		else{
			newDirectory(smbLocation);
		}
	}
}
