package game.player

/**
 * Класс описывающий предметы экипировки TODO а еще нужны обычные...или нет?
 * @param name название предмета
 * @param itemType тип предмета TODO я могу через тип предмета сделать обычные предметы неэкипируемымы и вопрос решен...наверное?
 * @param damage урон
 * @param defence защита
 * @param equipped экипирован ли предмет
 */
case class Item(name: String, itemType: String, damage: Int, defence: Int, var equipped: Boolean = false)
// подумать о том, чтобы итемы добавляли уклонение, попадание и прочее дерьмо....пока без этого
