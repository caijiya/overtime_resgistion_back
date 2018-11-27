package co.javaweb.overtime_resgistion.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;


/**
 * 
 * @author KevinBlandy
 *
 */
public class CommonUtils {
	
    public static final String[] NUMBERS_AND_LETTERS = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t", "u","v","w","x","y","z"};
	
	public static final String AJAX_HEADER_NAME = "x-requested-with";
	
	public static final String AJAX_HEADER_VALUE = "XMLHttpRequest";
	
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	//获取时间戳
	public static long timestamp() {
		return Instant.now().toEpochMilli();
	}
	
	//base64编码
	public static String encodeBase64(byte[] data) {
		return new String(Base64.getEncoder().encode(data),StandardCharsets.UTF_8);
	}
	
	//base64解码
	public static byte[] decodeBase64(String data) {
		return Base64.getDecoder().decode(data.getBytes(StandardCharsets.UTF_8));
	}
	
	//获取32位无符号uuid
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
			
	//是否是ajax请求
	public static boolean isAjax(HttpServletRequest request) {
		return request.getHeader(AJAX_HEADER_NAME) != null;
	}

	//响应json
	public static void response(HttpServletResponse response, Object responseBody) throws IOException {
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
    	response.getWriter().write(JSON.toJSONString(responseBody));
    	response.setStatus(HttpServletResponse.SC_OK);
    	response.flushBuffer();
	}

	//获取客户端ip
	public static String getRemoteAddr(HttpServletRequest request) {
    	String ip = request.getHeader("X-Requested-For");
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if(StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	//获取随机的字符串,包括数字和字母
    public static String getRandomString(int length) {
    	Random random = new Random();
    	StringBuilder stringBuilder = new StringBuilder(length);
        boolean [] flags = new boolean[] {true,false};
        for(int x = 0;x < length ; x++){
        	String randomString = NUMBERS_AND_LETTERS[random.nextInt(NUMBERS_AND_LETTERS.length)];
        	if(flags[random.nextInt(flags.length)]) {
        		randomString = randomString.toUpperCase();
        	}
        	stringBuilder.append(randomString);
        }
        return stringBuilder.toString();
    }

    //从类路径下加载文本数据
    public static String getResurce(String classPath) throws IOException {
    	try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(CommonUtils.class.getResourceAsStream(classPath),StandardCharsets.UTF_8))){
    		StringBuilder stringBuilder = new StringBuilder();
    		String line = bufferedReader.readLine();
    		while(line != null) {
    			stringBuilder.append(line).append(LINE_SEPARATOR);
    			line = bufferedReader.readLine();
    		}
    		return stringBuilder.toString();
    	}
    }
    
    //获取数组中的随机值
    public static <T> T choose(T[] arr) {
    	return arr[new Random().nextInt(arr.length)];
    }

    //判断资源是否是图片文件
    public static boolean isImage(InputStream inputStream) {
		if (inputStream == null) {
            return false;
        }
        Image image;
        try {
        	image = ImageIO.read(inputStream);
            return !(image == null || image.getWidth(null) <= 0 || image.getHeight(null) <= 0);
        } catch (Exception e) {
            return false;
        }
	}
}








