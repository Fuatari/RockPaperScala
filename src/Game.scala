class Game {
  def div() = println("--------------------------------")

  def play(playerName: String, roundCount: Double) = {
    var playerScore = 0
    var aiScore = 0
    val winningScore = math.ceil(roundCount / 2).toInt

    while (playerScore < winningScore && aiScore < winningScore) {
      div()

      print("Choose your hand (rock, paper, scissors): ")
      val playerHandString = scala.io.StdIn.readLine()

      div()

      println(playerName + " chose " + playerHandString)

      val aiHandInt = scala.util.Random.nextInt(3)
      var aiHandString = ""

      aiHandInt match {
        case 0 => aiHandString = "rock"
        case 1 => aiHandString = "paper"
        case 2 => aiHandString = "scissors"
      }

      println("Computer chose " + aiHandString)

      div()

      if (playerHandString.equalsIgnoreCase(aiHandString)) println("It's a draw!")
      else {
        var handResult = result(playerHandString, aiHandString)
      }

      println(playerName + ": " + playerScore)
      println("Computer: " + aiScore)

      if (playerScore == winningScore) print(playerName + " wins!")
      else if (aiScore == winningScore) print("Computer wins!")
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