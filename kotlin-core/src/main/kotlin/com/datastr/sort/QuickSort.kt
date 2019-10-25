package com.datastr.sort

import kotlin.streams.toList

fun quickSort(list: List<Int>): List<Int> {
    return if (list.isEmpty())
        list
    else {
        val sortedList = ArrayList<Int>()
        val pivot = list[0]
        sortedList.addAll(quickSort(filter(list) { it < pivot }))
        sortedList.addAll(filter(list) { it == pivot })
        sortedList.addAll(quickSort(filter(list) { it > pivot }))
        sortedList
    }
}

private fun filter(list: List<Int>, lambda: (t: Int) -> Boolean) =
        list.stream().filter(lambda).toList()