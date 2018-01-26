class AI {
  var rockCount = 0
  var paperCount = 0
  var scissorsCount = 0

  def getName(aiStrength: String) = {
    var aiName = ""
    aiStrength match {
      case "easy" => aiName = "Easy Mode"
      case "medium" => aiName = "Computer"
      case "hard" => aiName = "Nightmare"
      case _ => aiName = "???"
    }
    aiName
  }

  def aiTurn(aiStrength: String): Int = {
    val aiRandInt = scala.util.Random.nextInt(3)
    var aiRandomness = 0
    var aiChoice = -1

    aiStrength match {
      case "easy" => aiRandomness = -1
      case "medium" => aiRandomness = 70
      case "hard" => aiRandomness = 35
      case _ => aiRandomness = scala.util.Random.nextInt(101)
    }

    if (rockCount == 0 && paperCount == 0 && scissorsCount == 0) aiChoice = aiRandInt
    else if (aiRandomness < scala.util.Random.nextInt(101)) aiChoice = aiRandInt
    else lookAtPlayerHistory match {
      case "rock" => aiChoice = 0
      case "paper" => aiChoice = 1
      case "scissors" => aiChoice = 2
    }
    aiChoice
  }

  def lookAtPlayerHistory: String = {
    if (rockCount > paperCount && rockCount > scissorsCount) "paper"
    if (paperCount > rockCount && paperCount > scissorsCount) "scissors"
    "rock"
  }

  def updatePlayerCount(playerChoice: String) = {
    playerChoice match {
      case "rock" => rockCount += 1
      case "paper" => paperCount += 1
      case "scissors" => scissorsCount += 1
      case _ => println("Try entering 'rock', 'paper' or 'scissors' next time")
    }
  }
}