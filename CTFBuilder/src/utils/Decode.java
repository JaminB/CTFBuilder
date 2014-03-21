package utils;
import org.apache.commons.codec.binary.Base64;

public class Decode {
	public String decode(String plainText){
		String decode = plainText;
		for(int i = 0; i < 11; i++){
			decode = new String(Base64.decodeBase64(decode.getBytes()));
		}
		return decode;
	}
}
