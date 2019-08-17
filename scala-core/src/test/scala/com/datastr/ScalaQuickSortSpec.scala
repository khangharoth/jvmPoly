package com.datastr

import java.util
import java.util.function.Consumer

import scala.collection.JavaConversions._
import org.scalatest.FlatSpec
import scala.collection.JavaConversions._

class ScalaQuickSortSpec extends FlatSpec {
  "List " should "have same no of elements After Sorting" in {

    val integers: List[Integer] = List[Integer](4, 2, 3, 2)
    val sortedList: List[Integer] = ScalaQuickSort.sort(integers)
    assert(sortedList.size == integers.size)
  }

  "List elements" should "be in increasing order" in {

    val integers: List[Integer] = List[Integer](4, 2, 3, 2)
    val sortedList: List[Integer] = ScalaQuickSort.sort(integers)

    sortedList.forEach(new Consumer[Integer] {
      override def accept(t: Integer): Unit = println(t)
    })


  }

}
