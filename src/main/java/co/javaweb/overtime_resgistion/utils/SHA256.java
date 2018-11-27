package co.javaweb.overtime_resgistion.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	
	/**
	 * sha256
	 * @param source
	 * @return
	 */
	public static String digest(String source) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(source.getBytes(StandardCharsets.UTF_8));
			return HexByteUtils.bytesToHexString(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
