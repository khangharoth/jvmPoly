package com.datastr.sort

import org.scalatest.{BeforeAndAfterAll, FunSuite, Matchers}

class ScalaSortFixedTest extends FunSuite with Matchers with BeforeAndAfterAll {
  test("List  should have same no of elements After Sorting in") {

    val integers: List[Integer] = List[Integer](4, 2, 3, 2)
    val sortedList: List[Integer] = ScalaSelectionSort.sort(integers)
    assert(sortedList.size == integers.size)
  }

}
