package com.datastr

import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._
import org.scalatest.{BeforeAndAfterAll, FunSuite, Matchers}
import org.scalatestplus.scalacheck.Checkers.check

class ScalaQuickSortPropSpec extends FunSuite with Matchers with BeforeAndAfterAll {
  test("should be") {

    check((a: List[Int], b: List[Int]) => {
      println(a + " : " + b)
      a.size + b.size == (a ::: b).size
    })
  }
}
