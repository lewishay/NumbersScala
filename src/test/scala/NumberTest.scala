import org.scalatest.FlatSpec

/**
  * Created by Administratgit remote set-url origin git://new.url.hereor on 18/07/2017.
  */
class NumberTest extends NumSpec {
  "The getResult function" should "not be called when a number less than 10^6 is inputted" in {
    assert(Main.getLongAndShort(450) === "The number is too low! Please keep it above one million!")
  }

  it should "not be called when a number greater than 10^24 is inputted" in {
    assert(Main.getLongAndShort(BigInt("968574638601237483787968749584")) === "The number is too big! Please keep it below 10^24!")
  }

  it should "return the correct string for a valid number" in {
    assert(Main.getLongAndShort(8761237653452L) === "Short scale: 8 trillion 761 billion 237 million 653 thousand and 452." + "\n" +
                      "Long scale: 8 billion 761 milliard 237 million 653 thousand and 452.")
    assert(Main.getLongAndShort(95867584) === "Short scale: 95 million 867 thousand and 584." + "\n" +
                      "Long scale: 95 million 867 thousand and 584.")
    assert(Main.getLongAndShort(BigInt("895894534897563477896389")) === "Short scale: 895 sextillion 894 quintillion 534 quadrillion " +
                      "897 trillion 563 billion 477 million 896 thousand and 389." + "\n" + "Long scale: 895 trilliard 894 trillion " +
                      "534 billiard 897 billion 563 milliard 477 million 896 thousand and 389.")
  }
}
