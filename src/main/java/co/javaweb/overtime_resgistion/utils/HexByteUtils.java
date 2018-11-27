package co.javaweb.overtime_resgistion.utils;
/**
 * 
 * @author KevinBlandy
 *
 */
public class HexByteUtils {
	
	/**
	 * 字节数组转换为16进制字符串
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexString(byte[] bytes) {
		StringBuilder stringBuilder = new StringBuilder();
		if (bytes == null || bytes.length <= 0) {
			return null;
		}
		for (int i = 0; i < bytes.length; i++) {
			int value = bytes[i] & 0xFF;
			String hexValue = Integer.toHexString(value);
			if (hexValue.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hexValue);
		}
		return stringBuilder.toString();
	}

	/**
	 * 单个字节转换为16进制字符串
	 * @param bin
	 * @return
	 */
	public static String toHex(byte bin) {
		String result = Integer.toHexString(bin & 0xFF);
		if (result.length() == 1) {
			result = '0' + result;
		}
		return result;
	}

	/**
	 * 16进制字符串转换为字节数组
	 * @param hexString
	 * @return
	 */
	public static byte[] hexStringToBytes(String hexString) {
		if (hexString == null || hexString.equals("")) {
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() / 2;
		char[] hexChars = hexString.toCharArray();
		byte[] result = new byte[length];
		for (int i = 0; i < length; i++) {
			int position = i * 2;
			result[i] = (byte) (charToByte(hexChars[position]) << 4 | charToByte(hexChars[position + 1]));
		}
		return result;
	}

	/**
	 * char转换为byte
	 * @param cha
	 * @return
	 */
	public static byte charToByte(char cha) {
		return (byte) "0123456789ABCDEF".indexOf(cha);
	}

	/**
	 *  获取指定16进制数值的反码
	 * @param hex
	 * @return
	 */
	public static String getHexComplement(String hex) {
		int result = 255 - Integer.parseInt(hex, 16);
		String hexResult = Integer.toHexString(result);
		if (hexResult.length() == 1) {
			hexResult = "0" + hexResult;
		}
		return hexResult.toUpperCase();
	}
}
