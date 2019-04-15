package model

import scala.collection.mutable.ListBuffer

object Database {
  private val lake = new Hotel("Lakewood", 3)
  private val bridge = new Hotel("Bridgewood", 4)
  private val ridge = new Hotel("Ridgewood", 5)

  val hotelList: ListBuffer[Hotel] = ListBuffer.empty[Hotel]
  hotelList += lake
  hotelList += bridge
  hotelList += ridge

  lake.regMap += (Day.WEEKDAY -> 110, Day.WEEKEND -> 90)
  lake.luxMap += (Day.WEEKDAY -> 80, Day.WEEKEND -> 80)

  bridge.regMap += (Day.WEEKDAY -> 160, Day.WEEKEND -> 60)
  bridge.luxMap += (Day.WEEKDAY -> 110, Day.WEEKEND -> 50)

  ridge.regMap += (Day.WEEKDAY -> 220, Day.WEEKEND -> 150)
  ridge.luxMap += (Day.WEEKDAY -> 100, Day.WEEKEND -> 40)

}
