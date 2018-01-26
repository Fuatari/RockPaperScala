class AI {
  var moveHistory = Array.empty[String]

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

  def aiTurn(aiStrength: String, playerChoice: String): Int = {
    val aiRandInt = scala.util.Random.nextInt(3)
    var aiRandomness = -1
    var aiChoice = -1

    aiStrength match {
      case "easy" => aiRandomness = 0
      case "medium" => aiRandomness = 70
      case "hard" => aiRandomness = 35
      case _ => aiRandomness = scala.util.Random.nextInt(101)
    }

    playerChoice match {
      case "rock" =>  
      case "paper" =>
      case "scissors" =>
      case _ =>
    }

    aiChoice
  }
}