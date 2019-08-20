package com.datastr

import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._
import org.scalatest.{BeforeAndAfterAll, FunSuite, Matchers}
import org.scalatestplus.scalacheck.Checkers.check

class ScalaQuickSortPropSpec extends FunSuite with Matchers with BeforeAndAfterAll {
  test("should be") {

    check((a: List[Int]) => {
      println(a)

      val numbers = a.map(x => new Integer(x.toString))
      val sortedList: List[Integer] = ScalaQuickSort.sort(numbers)
      numbers.sorted == sortedList
    })
  }
}
