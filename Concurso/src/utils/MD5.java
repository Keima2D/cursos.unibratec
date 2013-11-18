package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	private String string;
	private String hash;
	
	public MD5 (Object obj) {
		this.string = obj.toString();
		
		String digest = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(this.string.getBytes("UTF-8"));
           
            //converting byte array to Hexadecimal String
           StringBuilder sb = new StringBuilder(2 * hash.length);
           for(byte b : hash){
               sb.append(String.format("%02x", b&0xff));
           }
          
           digest = sb.toString();
          
        } catch (UnsupportedEncodingException ex) {
            
        } catch (NoSuchAlgorithmException ex) {
            
        }
        
        this.hash = digest;		
	}
	
	public String getHash () {
		return this.hash;
	}
}
