package utils;

import java.io.File;
import java.net.MalformedURLException;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;

public class Delete {

	public void delete(String fileLocation){
		File delete = new File(fileLocation);
		delete.delete();
	}
	
	public void delete(String smbLocation, boolean smb) throws MalformedURLException, SmbException{
		System.out.println("Deleting smb? " + smb);
                if(smb){
			SmbFile smbFile = new SmbFile(smbLocation);
			smbFile.delete();
		}
		else
			delete(smbLocation);
	}
	
}
