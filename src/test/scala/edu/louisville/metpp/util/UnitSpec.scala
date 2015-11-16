package edu.louisville.metpp.util

import org.joda.time.DateTime
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, FlatSpec, Matchers}

trait UnitSpec extends FlatSpec with Matchers with BeforeAndAfterAll with BeforeAndAfterEach {

  final val now = DateTime.now

}
