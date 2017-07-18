/**
  * Created by Administrator on 18/07/2017.
  */
object Main extends App {
  try {
    val arg = BigInt(scala.io.StdIn.readLine("Please enter a number greater than one million."))
    print(getLongAndShort(arg))
  }
  catch {
    case e: NumberFormatException => print("Something went wrong. Please enter a reasonable number!")
  }

  val million = Math.pow(10, 6).toLong
  val billion = Math.pow(10, 9).toLong
  val trillion = Math.pow(10, 12).toLong
  val quadrillion = Math.pow(10, 15).toLong
  val quintillion = Math.pow(10, 18).toLong
  val sextillion = BigInt("1000000000000000000000")
  val tooHigh = BigInt("1000000000000000000000000")

  def getLongAndShort(number: BigInt): String = number match {
    case _ if(number >= million && number < billion) => getResult(number, 2)
    case _ if(number >= billion && number < trillion) => getResult(number, 3)
    case _ if(number >= trillion && number < quadrillion) => getResult(number, 4)
    case _ if(number >= quadrillion && number < quintillion) => getResult(number, 5)
    case _ if(number >= quintillion && number < sextillion) => getResult(number, 6)
    case _ if(number >= sextillion && number < tooHigh) => getResult(number, 7)
    case _ if(number > tooHigh) => "The number is too big! Please keep it below 10^24!"
    case _ => "The number is too low! Please keep it above one million!"
  }

  def getResult(theNumber: BigInt, loopVal: Int): String = {
    val shortScale = Array("and", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion")
    val longScale = Array("and", "thousand", "million", "milliard", "billion", "billiard", "trillion", "trilliard")
    val num = theNumber.toString
    val shortResult = StringBuilder.newBuilder
    shortResult.append("Short scale: ")
    val longResult = StringBuilder.newBuilder
    longResult.append("Long scale: ")
    val remainder = num.length % 3
    num match {
      case _ if(remainder == 1) => {shortResult.append(num(0).toString + " "); longResult.append(num(0).toString + " ")
        shortResult.append(shortScale(loopVal) + " "); longResult.append(longScale(loopVal) + " ")}
      case _ if(remainder == 2) => {shortResult.append(num.substring(0, 2) + " "); longResult.append(num.substring(0, 2) + " ")
        shortResult.append(shortScale(loopVal) + " "); longResult.append(longScale(loopVal) + " ")}
      case _ if(remainder == 0) => {shortResult.append(num.substring(0, 3) + " "); longResult.append(num.substring(0, 3) + " ")
        shortResult.append(shortScale(loopVal) + " "); longResult.append(longScale(loopVal) + " ")}
    }
    for(i <- 1 to loopVal) {
      if(i == loopVal) {
        shortResult.append(shortScale(loopVal-i) + " "); longResult.append(longScale(loopVal-i) + " ")
        if(remainder == 0) {
          shortResult.append(num.substring((i * 3), (i * 3) + 3) + ".")
          longResult.append(num.substring((i * 3), (i * 3) + 3) + ".")
        }
        else {
          shortResult.append(num.substring((i * 3) - 3 + remainder, (i * 3) + remainder) + ".")
          longResult.append(num.substring((i * 3) - 3 + remainder, (i * 3) + remainder) + ".")
        }
      }
      else {
        if(remainder == 0) {
          shortResult.append(num.substring((i * 3), (i * 3) + 3) + " ")
          longResult.append(num.substring((i * 3), (i * 3) + 3) + " ")
        }
        else {
          shortResult.append(num.substring((i * 3) - 3 + remainder, (i * 3) + remainder) + " ")
          longResult.append(num.substring((i * 3) - 3 + remainder, (i * 3) + remainder) + " ")
        }
        shortResult.append(shortScale(loopVal-i) + " "); longResult.append(longScale(loopVal-i) + " ")
      }
    }
    shortResult + "\n" + longResult
  }
}
