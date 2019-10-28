package com.datastr.highOrderFn

import junit.framework.Assert.assertEquals
import org.junit.Test

class HighOrderFnTest {
    @Test
    fun `compose Two Functions Test`() {
        assertEquals(16, applyTwice({ a: Int -> a + 3 }, 10))
    }
}