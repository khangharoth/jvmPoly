package com.datastr.sort

import org.junit.Test

class QuickSortTest {
    @Test
    fun `doQuicksort`() {
        val numbers = listOf(3, 5, 1, 2)

        println(quickSort(numbers))
    }
}



