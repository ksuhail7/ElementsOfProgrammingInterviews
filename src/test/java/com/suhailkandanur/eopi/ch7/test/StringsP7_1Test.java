package com.suhailkandanur.eopi.ch7.test;

import com.suhailkandanur.eopi.ch7.StringsP7_1;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by suhail on 2016-10-30.
 */

public class StringsP7_1Test {

    @Test
    public void testStrToIntConversion() throws Exception {
        assertEquals(-123, StringsP7_1.parseInt("-123"));
        assertEquals(123, StringsP7_1.parseInt("123"));
        assertEquals(0, StringsP7_1.parseInt("0"));
        assertEquals(0, StringsP7_1.parseInt("-0"));
    }

    @Test(expected = Exception.class)
    public void strToIntConversionThrowsException() throws Exception {
        StringsP7_1.parseInt("12-3");
    }

    @Test
    public void intToStrConversion() {
        assertEquals("123", StringsP7_1.intToStr(123));
        assertEquals("-123", StringsP7_1.intToStr(-123));
        assertEquals("0", StringsP7_1.intToStr(0));
        assertEquals("0", StringsP7_1.intToStr(-0));
    }
}
