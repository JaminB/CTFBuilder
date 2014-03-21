package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;
import utils.Encode;

public class WriteOut {
	
	public void write(String fileLocation, String text) throws IOException{
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileLocation, true)));
		out.println(new Encode().encode(text));
		out.close();
	}

	
	public void write(String smbLocation, String text, boolean smb) throws IOException{
		if(smb){
			SmbFile smbFile = new SmbFile(smbLocation);
			SmbFileOutputStream smbFileOutputStream = new SmbFileOutputStream(smbFile, true);
			smbFileOutputStream.write((new Encode().encode(text) + "\n").getBytes());
			smbFileOutputStream.close();
		}
		else{
			write(smbLocation, text);
		}
		
	}
}
