package utility

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DatetoDay {
  val df: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

  def isWeekday(date: String): Boolean = {
    LocalDate.parse(date, df).getDayOfWeek.getValue match {
      case 1 | 2 | 3 | 4 | 5 => true
      case 6 | 7 => false
    }
  }
}
