package utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

public class _Test {
	public static void main(String args[]) throws MalformedURLException, UnknownHostException, IOException{
	ReadIn smb = new ReadIn();
	WriteOut smbOut = new WriteOut();
	//new Delete().delete("smb://107.170.39.131/ctf/x.txt", true);
	//smbOut.write("smb://107.170.39.131/ctf/x.txt", "test10", true);
	//System.out.println(smb.read("smb://107.170.39.131/ctf/x.txt", true));
	NewOps smb2 = new NewOps();
	smb2.newDirectory("/home/jamin/super");
	smb2.newFile("/home/jamin/super/challenges.ctf");
	smb2.newDirectory("smb://107.170.39.131/ctf/Test", true);
	smb2.newFile("smb://107.170.39.131/ctf/Test/test.txt", true);
	}
}
