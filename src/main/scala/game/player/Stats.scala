package game.player

/**
 * Класс описывающий характеристики персонажа
 */
case class Stats(var maxHp: Int = 10, var maxMp: Int = 1, var strength: Int = 1, var dexterity: Int = 1,
                 var intelligence: Int = 1, var charisma: Int = 1, var lucky: Int = 1) {

  private var _curHp: Int = maxHp
  private var _curMp: Int = maxMp
  def curHp: Int = _curHp
  def curHp(r: Int): Unit = {
    _curHp += r
    if (_curHp > maxHp)
      fullHp()
    if (_curHp < 0)
      _curHp = 0
  }
  def curMp: Int = _curMp
  def curMp(r: Int): Unit = {
    _curMp += r
    if (_curMp > maxMp)
      fullMp()
    if (_curMp < 0)
      _curMp = 0
  }

  def fullHp(): Unit = _curHp = maxHp
  def fullMp(): Unit = _curMp = maxMp

  def getStatByString(name: String): Int =
    name match {
      case "strength" => this.strength
      case "dexterity" => this.dexterity
      case "intelligence" => this.intelligence
      case "charisma" => this.charisma
      case "lucky" => this.lucky
    }

  def appendStatByString(name: String, value: Int = 1): Unit = {
    name match {
      case "maxHp" => this.maxHp += value
      case "maxMp" => this.maxMp += value
      case "hp" => curHp(value)
      case "mp" => curMp(value)
      case "strength" => this.strength += value
      case "dexterity" => this.dexterity += value
      case "intelligence" => this.intelligence += value
      case "charisma" => this.charisma += value
      case "lucky" => this.lucky += value
    }
  }
}