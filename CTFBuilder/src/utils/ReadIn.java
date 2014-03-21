package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFileInputStream;
import utils.Decode;
public class ReadIn {
	ArrayList<String> lines = new ArrayList<String>();
	
	public ArrayList<String> read(String fileLocation) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
		String line = "";
		while ((line = reader.readLine()) != null) {
		  lines.add(new Decode().decode(line));
		}
		reader.close();
		return lines;
	}
	
	public ArrayList<String> read(String smbLocation, boolean smb) throws IOException, MalformedURLException, UnknownHostException{
		String line = "";
                System.out.print("smb on? " + smb);
		if(smb){
                        System.out.println("Value: " +smbLocation);
			BufferedReader reader = new BufferedReader(new InputStreamReader(new SmbFileInputStream(smbLocation)));
			while ((line = reader.readLine()) != null) {
				  lines.add(new Decode().decode(line));
				}
				reader.close();
				return lines;
		}
		else{
			return read(smbLocation);
		}
	}
}
