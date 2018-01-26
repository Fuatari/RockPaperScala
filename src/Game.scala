class Game {
  def div() = println("--------------------------------")
  val AI = new AI
  
  val playerName = ""
  val aiStrength = ""
  var roundCount = -1

  def init = {
    print("Enter your name: ")
    val playerName = scala.io.StdIn.readLine
    print("Opponent difficulty; easy, medium or hard? ")
    val aiStrength = scala.io.StdIn.readLine.toLowerCase
    print("Maximum rounds to play? ")
    val roundCount = scala.io.StdIn.readDouble
  }

  def play = {
    var playerScore = 0
    var aiScore = 0
    var round = 1
    var aiName = AI.getName(aiStrength)
    val winningScore = math.ceil(roundCount / 2).toInt

    while (playerScore < winningScore && aiScore < winningScore) {
      div()

      print("Round " + round)
      print("Rock, Paper or Scissors? ")
      val playerHandString = scala.io.StdIn.readLine.toLowerCase

      div()

      println(playerName + " chose " + playerHandString)

      var aiHandString = ""
      AI.aiTurn(aiStrength, playerHandString) match {
        case 0 => aiHandString = "rock"
        case 1 => aiHandString = "paper"
        case 2 => aiHandString = "scissors"
      }
      println(aiName + " chose " + aiHandString)

      div()

      if (playerHandString.equalsIgnoreCase(aiHandString)) println("It's a draw!")
      else result(playerHandString, aiHandString)

      println(playerName + ": " + playerScore)
      println(aiName + ": " + aiScore)
      round += 1

      if (playerScore == winningScore) print(playerName + " wins!")
      else if (aiScore == winningScore) print(aiName + " wins!")
    }

    def result(player: String, ai: String) = {
      var result = -1
      (player, ai) match {
        case ("rock", "paper") => aiScore += 1
        case ("rock", "scissors") => playerScore += 1

        case ("paper", "rock") => playerScore += 1
        case ("paper", "scissors") => aiScore += 1

        case ("scissors", "rock") => aiScore += 1
        case ("scissors", "paper") => playerScore += 1

        case (_, _) => aiScore += 1
      }
    }
  }
}