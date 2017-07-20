package example

import com.typesafe.config.ConfigFactory

object Hello extends Greeting with App {
  val greetingMessage = ConfigFactory.load().getString("greetingmessage")
  println(greetingMessage)
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "hello with new changes"
}
