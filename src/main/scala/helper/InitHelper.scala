package helper

import game.location.{Choice, Requirement}
import helper.JsonHelper.getStringValue
import ujson.Value.Value

object InitHelper {

  def getRequirements(value: Value): List[Requirement] =
    value
      .arr
      .map(x => new Requirement(getAnyMapValue(x)))
      .toList

  def getChoices(value: Value): List[Choice] =
    value
      .arr
      .map(x => new Choice(
        name = getStringValue(x("name")),
        requirements = getRequirements(x("requirements")),
        exam = getIntMapValue(x("exam")),
        result = ??? // TODO make two different result field
      ))


  def getAnyMapValue(value: Value): Map[String, Any] =
    getPrevMapValue(value).asInstanceOf[Map[String, Any]]

  def getIntMapValue(value: Value): Map[String, Int] =
    getPrevMapValue(value).asInstanceOf[Map[String, Int]]

  def getPrevMapValue(value: Value): Array[(Any, Any)] =
    value
      .str
      .split(",")
      .map(_.split(":"))
      .map { case (k, v) => (k, v) }
}
