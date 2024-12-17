package helper

import game.environment.{Choice, Requirement}
import helper.JsonHelper.getStringValue
import ujson.Value.Value

object InitHelper {

  def getRequirements(value: Value): Requirement = new Requirement(getStringMapValue(value))

  def getChoices(value: Value): List[Choice] =
    value
      .arr
      .map(x => new Choice(
        name = getStringValue(x("name")),
        requirements = getRequirements(x("requirements")),
        exam = getIntMapValue(x("exam")),
        success = getStringMapValue(x("success")),
        failure = getStringMapValue(x("failure"))))
      .toList

  def getStringMapValue(value: Value): Map[String, String] =
    getPrevMapValue(value).asInstanceOf[Map[String, String]]

  def getIntMapValue(value: Value): Map[String, Int] =
    getPrevMapValue(value).asInstanceOf[Map[String, Int]]

  def getPrevMapValue(value: Value)=
    value
      .str
      .split(",")
      .map(_.split(":"))
      .map { case (k, v) => (k, v) }
      .toMap // ???

}
