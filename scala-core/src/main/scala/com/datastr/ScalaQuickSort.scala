package com.datastr

import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer


object ScalaQuickSort {
  def sort(elements: List[Integer]): List[Integer] = {
    if (elements.isEmpty) {
      return List[Integer]()
    }
    val pivot: java.lang.Integer = elements.get(0)
    val sortedList: ListBuffer[Integer] = ListBuffer[Integer]()


    sortedList.addAll(sort(elements.filter(_ < pivot)))
    sortedList.addAll(elements.filter(_ == pivot))
    sortedList.addAll(sort(elements.filter(_ > pivot)))

    sortedList.toList
  }

}
