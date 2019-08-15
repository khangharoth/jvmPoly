package com.datastr

import java.util

import org.scalatest.FlatSpec

class ScalaQuickSortSpec extends FlatSpec {
  "QuickSort " should "have same no of elements" in {

    val integers: util.List[Integer] = util.Arrays.asList(4, 2, 3, 2)
    val sortedList: util.List[Integer] = ScalaQuickSort.sort(integers)
    assert(sortedList.size == integers.size)
  }

}
