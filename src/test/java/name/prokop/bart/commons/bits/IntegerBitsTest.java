/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package name.prokop.bart.commons.bits;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntegerBitsTest {

    public IntegerBitsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of promote method, of class IntegerBits.
     */
    @Test
    public void testPromote() {
        System.out.println("promote");

        byte b = 0;
        int expResult = 0;
        int result = IntegerBits.promote(b);
        assertEquals(expResult, result);

        b = 1;
        expResult = 1;
        result = IntegerBits.promote(b);
        assertEquals(expResult, result);

        b = -1;
        expResult = 255;
        result = IntegerBits.promote(b);
        assertEquals(expResult, result);

        b = (byte) 0xff;
        expResult = 255;
        result = IntegerBits.promote(b);
        assertEquals(expResult, result);
    }

    /**
     * Test of buildInt method, of class IntegerBits.
     */
    @Test
    public void testBuildInt() {
        System.out.println("buildInt");

        byte[] a = new byte[]{1, 2};
        int expResult = 1 * 256 + 2;
        int result = IntegerBits.build(a);
        assertEquals(expResult, result);

        a = new byte[]{1, 2, 3, 4};
        expResult = 1 * 256 * 256 * 256 + 2 * 256 * 256 + 3 * 256 + 4;
        result = IntegerBits.build(a);
        assertEquals(expResult, result);
        result = IntegerBits.build((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        assertEquals(expResult, result);
    }
}