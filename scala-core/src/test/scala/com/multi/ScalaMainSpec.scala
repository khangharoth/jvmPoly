package com.multi

import org.scalatest.FlatSpec

class ScalaMainSpec extends FlatSpec {
  "Sum " should "add two numbers" in {
    assert(ScalaMain.sum(2, 3) === 5)
  }
}
