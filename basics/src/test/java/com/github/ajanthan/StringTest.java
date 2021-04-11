package com.github.ajanthan;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class StringTest {
    @Test
    public void basicTest() {
        String name0 = String.valueOf(new char[]{ 's', 'a', 'm', 'a', 'n' });
        String name1 = "saman";
        Assert.assertTrue(name0 != name1);
        Assert.assertTrue("saman".equals(name1));
        Assert.assertTrue(name0.equals(name1));
        Assert.assertTrue(Objects.equals(name0, name1));
        Assert.assertTrue(name0.equalsIgnoreCase(name1));
        switch (name0) {
            case "saman":
                break;
            default:
                Assert.fail();
        }
        //contains
        Assert.assertTrue(name0.contains("man"));
        //indexOf
        Assert.assertEquals(2, name0.indexOf("man"));
    }

    @Test
    public void reverseTest() {
        String[] ins = { "test", "123", "@#$", "1a2b" };
        String[] revs = { "tset", "321", "$#@", "b2a1" };
        for (int i = 0; i < ins.length; i++) {
            Assert.assertTrue(reverse(ins[i]).equals(revs[i]));
        }
    }

    public String reverse(String in) {
        if (in.isEmpty()) {
            return in;
        }
        char[] chars = in.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return String.copyValueOf(chars);
    }
}
