package es.indra.inc.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;





public class Encriptacion {
	
	private static Charset DEFAULT_CHARSET = Charsets.ISO_8859_1;
	
	public static void main(String [] args) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		
		/*String jversion = "II1.0.4";
		String order = "Personal,Credit,Card,Ipf,Loan,Fund,CD,RF,PP";
		
		if(jversion!=null){
			if( jversion.startsWith("I") && !jversion.contains("1.0.19") )
				order = order.replace(",PP", "");
		}
		  	
		System.out.println( order );*/
		
		//07lufa05	
		String jversion="II";
		
		if(jversion!=null){
			if( jversion.startsWith("I") && (!jversion.contains("1.0.19") && !jversion.contains("1.0.20")) )
				System.out.println("Los quito");
		}
		
		System.out.println( tripleDesDecode( new String("A49B30F83FF883E8".getBytes() , DEFAULT_CHARSET) ) );
		//System.out.println( tripleDesEncode( new String("123124".getBytes() , DEFAULT_CHARSET) ) );
	}
	
public static String tripleDesDecode(String encryptValue) throws UnsupportedEncodingException {

		try {
			
			Cipher encryptCipher = Cipher.getInstance("DESede/CBC/NoPadding");
			
			byte[] bytes = Encriptacion.afterPropertiesSet().getBytes( DEFAULT_CHARSET );
			IvParameterSpec iv = new IvParameterSpec(new byte[8]);
			encryptCipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(bytes, "DESede"), iv);
			byte[] carac = Hex.decodeHex( encryptValue.toCharArray() );
			byte[] passw = encryptCipher.doFinal( carac );
			
			return new String(passw).trim();
			
		} catch (Throwable t) {
			return StringUtils.EMPTY;
		}

}

public static String tripleDesEncode(String rawValue) {
	
	try {
		Cipher encryptCipher = Cipher.getInstance("DESede/CBC/NoPadding");
		//System.out.println("EA" + Encriptacion.afterPropertiesSet());
		byte[] bytes = Encriptacion.afterPropertiesSet().getBytes( DEFAULT_CHARSET );
		// Vector de inicializaci�n: todo a ceros
		IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		encryptCipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(bytes, "DESede"), iv); 
		byte[] dataBytes = padWithSpaces(rawValue).getBytes();
		byte[] encryptedBytes = encryptCipher.doFinal(dataBytes);
        char[] encodedChars = Hex.encodeHex(encryptedBytes);
        return new String(encodedChars).toUpperCase();
	} catch (Throwable t) {
		return StringUtils.EMPTY;
	}
}



private static String padWithSpaces(String inputData) {
	int ln = inputData.length();
	if (ln % 8 > 0) {
		int newLength = ln + 8 - (ln % 8);
		inputData = StringUtils.rightPad(inputData, newLength);
	}
	return inputData;
}


public static String afterPropertiesSet() throws UnsupportedEncodingException {
	
		byte[] key = null;
		try {
			//Esta es la semilla que se calculan con operaciones xor
			key = Hex.decodeHex( "865E8C6BBC3D54B079017CF7A7108598865E8C6BBC3D54B0".toCharArray() );
			
			
		} catch (DecoderException e) {
			e.printStackTrace();
		} 
	
	 return  new String( key , DEFAULT_CHARSET  ) ;
	
}


}
