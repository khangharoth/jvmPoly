package com.datastr

import org.scalatest.{BeforeAndAfterAll, FunSuite, Matchers}

class ScalaQuickSortSpec extends FunSuite with Matchers with BeforeAndAfterAll {
  test("List  should have same no of elements After Sorting in") {

    val integers: List[Integer] = List[Integer](4, 2, 3, 2)
    val sortedList: List[Integer] = ScalaQuickSort.sort(integers)
    assert(sortedList.size == integers.size)
  }


  test("List elements should be in increasing order in") {

    val integers: List[Integer] = List[Integer](4, 2, 3, 2)
    val sortedList: List[Integer] = ScalaQuickSort.sort(integers)


    assert(integers.sorted == sortedList)


  }

}
