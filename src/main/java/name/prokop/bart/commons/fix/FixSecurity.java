package name.prokop.bart.commons.fix;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class FixSecurity {

    /**
     * This method uses reflection to remove security restriction from current
     * JVM. It shall be called as soon as possible when your program launches.
     *
     * @return if successfully removed all restriction
     */
    public static boolean removeRestriction() {
        return AccessController.doPrivileged(new PrivilegedAction<Boolean>() {

            @Override
            public Boolean run() {
                try {
                    Field field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
                    field.setAccessible(true);
                    field.set(null, java.lang.Boolean.FALSE);
                    return true;
                } catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                    return false;
                }
            }
        });
    }

}
