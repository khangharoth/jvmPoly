package com.multi;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ScalaClientTest {
    @Test
    public void shouldCallScalaCode() {


        Integer sum = ScalaMain.sum(2, 3);
        assertEquals(sum, new Integer(5));
    }
}
