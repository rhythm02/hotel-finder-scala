package model

class Hotel(var name: String, var rating:Int) {
  val regMap = scala.collection.mutable.Map[Day.Value, Int]()
  val luxMap = scala.collection.mutable.Map[Day.Value, Int]()
}
