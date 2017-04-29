package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import static util.JavaWebToken.verifyJavaWebToken;

public class AuthUtil {
	private static Map<String, Object> getClientLoginInfo(HttpServletRequest request) throws Exception {
        Map<String, Object> r = new HashMap<>();
        String sessionId = request.getHeader("sessionId");
        if (sessionId != null) {
            r = decodeSession(sessionId);
            return r;
        }
        throw new Exception("sessionΩ‚Œˆ¥ÌŒÛ");
    }

    public static Long getUserId(HttpServletRequest request) throws Exception {
        return  Long.valueOf((Integer)getClientLoginInfo(request).get("userId"));

    }

    /**
     * sessionΩ‚√‹
     */
    public static Map<String, Object> decodeSession(String sessionId) {
        try {
            return verifyJavaWebToken(sessionId);
        } catch (Exception e) {
            System.err.println("");
            return null;
        }
    }
}
