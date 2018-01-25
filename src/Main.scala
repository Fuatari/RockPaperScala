object Main extends App {

  val Game = new Game

  print("Enter your name: ")
  val playerName = scala.io.StdIn.readLine()
  print("Maximum rounds to play? ")
  val roundCount = scala.io.StdIn.readDouble()

  Game.play(playerName, roundCount)
}