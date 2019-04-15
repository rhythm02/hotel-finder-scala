package service

import model.{Hotel, Request}

trait CheapestHotel {
  def findCheapestHotel(req: Request):Hotel
}
