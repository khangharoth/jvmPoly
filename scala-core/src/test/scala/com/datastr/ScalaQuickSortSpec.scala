package com.datastr

import java.util
import java.util.function.Consumer

import scala.collection.JavaConversions._
import org.scalatest.FlatSpec

class ScalaQuickSortSpec extends FlatSpec {
  "List " should "have same no of elements After Sorting" in {

    val integers: util.List[Integer] = util.Arrays.asList(4, 2, 3, 2)
    val sortedList: util.List[Integer] = ScalaQuickSort.sort(integers)
    assert(sortedList.size == integers.size)
  }

  "List elements" should "be in increasing order" in {

    val integers: util.List[Integer] = util.Arrays.asList(4, 2, 3, 2)
    val sortedList: util.List[Integer] = ScalaQuickSort.sort(integers)

    sortedList.forEach(new Consumer[Integer] {
      override def accept(t: Integer): Unit = println(t)
    })


  }

}
