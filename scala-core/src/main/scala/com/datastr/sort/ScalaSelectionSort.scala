package com.datastr.sort

import java.util

import scala.collection.JavaConversions._

object ScalaSelectionSort extends ScalaSortAlgo {
  override def sortJava(elements: util.List[Integer]): util.List[Integer] = {
    sort(elements.toList)
  }

  override def sort(xs: List[Integer]): List[Integer] =
    if (xs.isEmpty) List()
    else {
      val ys = minimum(xs)
      if (ys.tail.isEmpty)
        ys
      else
        ys.head :: sort(ys.tail)
    }

  def minimum(xs: List[Integer]): List[Integer] =
    (List(xs.head) /: xs.tail) {
      (ys, x) =>
        if (x < ys.head) x :: ys
        else ys.head :: x :: ys.tail
    }
}
