package edu.louisville.metpp.test

import edu.louisville.metpp.UnitSpec

class testSpec extends UnitSpec {

  it should "get simple eval" in {
    val x = "hello world"
    println(s"the current time is $now")
    x shouldEqual "hello world"
  }

}
