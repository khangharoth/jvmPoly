package com.datastr

import java.util
import java.util.function.Predicate
import java.util.stream.Collectors.toList


object ScalaQuickSort {
  def sort(elements: util.List[Integer]): util.List[Integer] = {
    if (elements.size == 0) {
      return elements
    }
    val pivot: java.lang.Integer = elements.get(0)
    val sortedList: util.List[Integer] = new util.ArrayList[Integer]()


    sortedList.addAll(sort(filter(elements, new Predicate[Integer] {
      override def test(t: Integer): Boolean = t < pivot
    })))

    sortedList.addAll(filter(elements, new Predicate[Integer] {
      override def test(t: Integer): Boolean = t == pivot
    }))

    sortedList.addAll(sort(filter(elements, new Predicate[Integer] {
      override def test(t: Integer): Boolean = t > pivot
    })))

    sortedList
  }

  private def filter(elements: util.List[Integer],
                     integerPredicate: Predicate[Integer]): util.List[Integer] =
    elements.stream().filter(integerPredicate).collect(toList())
}
