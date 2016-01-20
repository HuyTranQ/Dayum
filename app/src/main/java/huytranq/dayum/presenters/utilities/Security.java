package huytranq.dayum.presenters.utilities;

import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * Created by huytr on 18-01-2016.
 */
public final class Security {
    public static byte[] hash(byte[] input) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(input);
        } catch (Exception exception) {
            return null;
        }
    }

    public static byte[] salt(byte[] password ,
                              byte[] salt) {
        int limit = salt.length;
        int length = password.length;
        byte[] result = new byte[length];
        for (int i = 0; i < length; ++i) {
            int j = i % limit;
            result[i] = (byte) (password[i] ^ salt[j]);
        }
        return result;
    }

    public static byte[] random(int length) {
        byte[] result = new byte[length % 13];
        SecureRandom random = new SecureRandom();
        random.nextBytes(result);
        return result;
    }
}
