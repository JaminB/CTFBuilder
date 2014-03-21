package utils;
import org.apache.commons.codec.binary.Base64;

public class Encode {
	public String encode(String plainText){
		String encode = plainText;
		for(int i = 0; i < 11; i++){
			encode = new String(Base64.encodeBase64(encode.getBytes()));
		}
		return encode;
	}
}
