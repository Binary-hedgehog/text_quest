package game.location.init

import game.location.{Choice, Event, Location, Requirement}
import helper.InitHelper._
import helper.JsonHelper._

object Initialisation {
  val tempPath1 = """D:\Profects\scala\text_quest\src\main\scala\helper\test1.json"""
  val tempPath2 = """D:\Profects\scala\text_quest\src\main\scala\helper\test2.json"""

  def initLocations(): List[Location] =
    getJsonValue(tempPath1)("locations")
      .arr
      .map(x => new Location(
        getStringValue(x("name")),
        getListOfString(x("events"))))
      .toList

  def initEvents(): List[Event] =
    getJsonValue(tempPath2)("events")
      .arr
      .map(x => new Event(
        name = getStringValue(x("name")),
        description = getStringValue(x("description")),
        requirements = getRequirements(x("requirements")),
        choices = getChoices(x("choices"))))
      .toList


}
