package util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import org.apache.log4j.Logger;

import javax.crypto.SecretKey;

import java.security.Key;
import java.util.Map;

public class JavaWebToken {
	private static Logger log = Logger.getLogger(JavaWebToken.class);

    private static Key getKeyInstance() {
//        return MacProvider.generateKey();
        //We will sign our JavaWebToken with our ApiKey secret
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("APP");
        SecretKey key = MacProvider.generateKey(signatureAlgorithm);
        
        //Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        return key;
    }

    public static String createJavaWebToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, getKeyInstance()).compact();
    }

    public static Map<String, Object> verifyJavaWebToken(String jwt) {
        try {
            Map<String, Object> jwtClaims = Jwts.parser().setSigningKey(getKeyInstance()).parseClaimsJws(jwt).getBody();
            return jwtClaims;
        } catch (Exception e) {
            log.error("json web token verify failed");
            return null;
        }
    }
}
