package name.prokop.bart.commons.dev;

import java.security.SecureRandom;

public class GenerateSerialVersion {

    public static void main(String... args) {
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        System.out.println("static final long serialVersionUID = " + nextLong + "L;");
    }
}
