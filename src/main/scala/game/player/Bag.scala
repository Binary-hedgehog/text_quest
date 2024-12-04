package game.player

import game.Constants.defaultBagSize

case class Bag(var size: Int = defaultBagSize, var items: Map[Int, Item] = Map()) {
  private var curNum = 0 // hidden param, append it while adding new item

  def addItem(item: Item): Boolean = {
    if (items.size < size) {
      items += (curNum -> item)
      curNum += 1
      true
    } else false
  }
  def dropItem(num: Int): Unit = items -= num
  // TODO подумать о требованиях для предметов в будущем
  def equipItem(num: Int): Unit = {
    items.values.filter(_.itemType == items(num).itemType).foreach(_.equipped = false)
    items(num).equipped = true
  }
  def unequippedItem(num: Int): Unit = items(num).equipped = false
}