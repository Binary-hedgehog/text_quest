package helper

import game.exceptions.JsonReadException
import ujson.Value.Value

import scala.util.Try
object JsonHelper {
  def getJsonValue(path: String): Value = {
    val source = scala.io.Source.fromFile(path)
    val data = try source.mkString finally source.close()
    ujson.read(data)
  }
  def getListOfString(value: Value): List[String] = Try(value.arr.map(getStringValue).toList).getOrElse(List())
  def getStringValue(value: Value): String = Try(value.str).getOrElse("")
  def getIntValue(value: Value): Int = Try(value.str.toInt).getOrElse(0)

  def getIntMapValue(value: Value): Map[String, Int] =
    getStringMapValue(value).asInstanceOf[Map[String, Int]]

  def getStringMapValue(value: Value): Map[String, String] =
    stringToMap(value.str)

  def stringToMap(str: String): Map[String, String] =
    str
      .split(",")
      .map(_.split(":"))
      .map { case Array(k, v) => (k.trim, v.trim) }
      .toMap


  //  def getListOfString(value: Value): List[String] = Try(value.arr.map(getStringValue).toList).getOrElse(new JsonReadException("Empty List of string"))
//  def getStringValue(value: Value): String = Try(value.str).getOrElse(new JsonReadException("Empty String"))
//  def getIntValue(value: Value): Int = Try(value.str.toInt).getOrElse(new JsonReadException("Empty Int"))
}


