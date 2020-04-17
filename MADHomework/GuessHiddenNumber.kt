package KTLN.MADHomework
import kotlin.random.Random

/***************************
 * Guess the 4 Digits Hidden Number
 * You have 10 trys
 * Correct Digits and Positions are given back
****************************/

fun createRandomArrayOfFourDigits():IntArray {      //Return Type declaration required =IntArray

    //empty IntArray
    var arrayOfDigits = IntArray(4);

    //Generate first random digit
    var newDigit: Int = Random.nextInt(0, 9)

    //In Array set Digit(Position, Generated Digit)
    arrayOfDigits.set(0, newDigit)

    //To check on Doubles in my Array
    fun checkDoubles(array: IntArray,digit: Int): Boolean {
        for (digitInArray in array ){
            if(digitInArray== digit) {
                return true             //if Double digit found
            }
        }
        return false;                   //no Doubles digits
    }

    //for the remaining 3 Digits
    for (i in 1..3) {
        //As long as Doubles occur generate a new Digit
        while (checkDoubles(arrayOfDigits, newDigit) == true) {
            newDigit = Random.nextInt(0, 9)
        }
        arrayOfDigits.set(i, newDigit)
    }
    return arrayOfDigits
}

//Actual game
fun guessTheHiddenNumber() {

    var hiddenNumberIntArray = createRandomArrayOfFourDigits()

    var hiddenNumberAsString:String = "";

    for (i in 0..3) {
        hiddenNumberAsString+= (hiddenNumberIntArray[i]);
    }
    println()
    println(hiddenNumberAsString);


    var countCorrectDigit: Int = 0
    var countCorrectPosition: Int = 0
    var digits:Int =4
    var trys:Int=10

    do {
        println("Guess the hidden number!")
        var userInput = readLine()!!    //per read as String

        if (userInput.length == digits) {

            if (userInput == hiddenNumberAsString) {
                println("\t\t\t $userInput is Correct!! Congratulation!")
                //countCorrectPosition += 1
                break
            }
            else {
                for (x in hiddenNumberAsString.indices)
                    for (i in userInput.indices) {
                        if (userInput[i] == hiddenNumberAsString[x]) {
                            countCorrectDigit += 1
                            println("\t\t\t Correct digit are ${userInput[i]}")
                        } else {
                        }
                    }
                println("\t\t\t $countCorrectDigit digits correct!")

                for (d in userInput.indices) {
                    if (userInput[d] == hiddenNumberAsString[d]) {
                        countCorrectPosition += 1
                    }
                }
            }
            println("\t\t\t $countCorrectPosition positions are correct")

        }
        else
        {
            println("\t\t\t Please enter 4 digits. Not more, not less!")
        }
        trys -= 1
        println("\t\t\t You have $trys trys left.")


    } while (trys>= 1)


}

