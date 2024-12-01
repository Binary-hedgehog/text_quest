package connector

import game.location.Event

abstract class Connector {
    def chooseEvent(events: List[Event]): Event


}

object Connector {
//  def chooseEvent(events: List[Event]): Event = {
//    //val event = chooseEventPlatform(chooseEvent)
//  }
}