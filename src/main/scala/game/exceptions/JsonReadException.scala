package game.exceptions

class JsonReadException(text: String) extends Exception{
  throw new Exception(text)
}
