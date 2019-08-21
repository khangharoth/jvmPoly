package com.datastr.sort

import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._
import org.scalatest.{BeforeAndAfterAll, FunSuite, Matchers}
import org.scalatestplus.scalacheck.Checkers.check

class ScalaSortTest extends FunSuite with Matchers with BeforeAndAfterAll {

  test("should have sorted elements in list by Quick Sort") {
    check((a: List[Int]) => {

      val numbers = a.map(x => new Integer(x.toString))
      val sortedList: List[Integer] = ScalaQuickSort.sort(numbers)
      numbers.sorted == sortedList
    })
  }
  test("should have sorted elements in list by Selection Sort") {
    check((a: List[Int]) => {
      val numbers = a.map(x => new Integer(x.toString))
      val sortedList: List[Integer] = ScalaSelectionSort.sort(numbers)
      numbers.sorted == sortedList
    })
  }
}
