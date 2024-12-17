package helper

import game.environment.{Choice, Requirement}
import helper.JsonHelper.{getIntMapValue, getStringMapValue, getStringValue}
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

}
