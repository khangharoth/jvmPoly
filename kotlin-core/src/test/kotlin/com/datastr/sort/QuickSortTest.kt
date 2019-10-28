package com.datastr.sort

import junit.framework.Assert.assertEquals
import org.junit.Test

class QuickSortTest {
    @Test
    fun `doQuicksort`() {
        val numbers = listOf(3, 5, 1, 2)


        assertEquals(numbers.sorted(), quickSort(numbers))
    }
}



