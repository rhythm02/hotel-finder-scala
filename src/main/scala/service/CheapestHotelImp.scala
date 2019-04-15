package service

import model.{Customer, Database, Hotel, Request}
import utility.DatetoDay

import scala.collection.mutable.ListBuffer

class CheapestHotelImp extends CheapestHotel {

  def findCheapestHotel(req: Request): Hotel = {
    val wd: Int = req.listDates.count(DatetoDay.isWeekday)
    val we: Int = req.listDates.filterNot(DatetoDay.isWeekday).length

    def getPrice(list: List[Int]): Int = {
      list.head * wd + list(1) * we
    }

    val hotelName: String = req.customer match {
      case Customer.REGULAR => Database.hotelList.map((h: Hotel) => h.name -> (h.rating, getPrice(h.regMap.values.toList.reverse)))
        .groupBy(_._2._2).toList.minBy(_._1)._2.minBy(-_._2._1)._1
      case Customer.REWARD => Database.hotelList.map((h: Hotel) => h.name -> (h.rating, getPrice(h.luxMap.values.toList.reverse)))
        .groupBy(_._2._2).toList.minBy(_._1)._2.minBy(-_._2._1)._1
    }

    Database.hotelList.filter(_.name == hotelName).head

    //Database.hotelList.map((h: Hotel) => h.name -> (h.rating, getPrice(h.regMap.values.toList.reverse)))
    //      .groupBy(_._2._2).toList.sortBy(_._1).head._2.sortBy(- _._2._1).head._1
  }
}

object CheapestHotelImp123 extends App {
  println(new CheapestHotelImp findCheapestHotel
    new Request(Customer.REGULAR, ListBuffer("11/04/2019", "14/04/2019", "13/04/2019")) name)
}
