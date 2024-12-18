package game.environment.init

import game.environment._
import helper.JsonHelper._
import ujson.Value.Value

import scala.util.Try

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

  def getRequirements(value: Value): Requirement = Try(new Requirement(getStringMapValue(value))).getOrElse(Map())

  def getChoices(value: Value): List[Choice] =
    value
      .arr
      .map(x => new Choice(
        name = getStringValue(x("name")),
        requirements = getRequirements(x("requirements")),
        exam = Try(getIntMapValue(x("exam"))).getOrElse(Map()),
        success = Try(getStringMapValue(x("success"))).getOrElse(Map()),
        failure = Try(getStringMapValue(x("failure"))).getOrElse(Map())))
      .toList

}
