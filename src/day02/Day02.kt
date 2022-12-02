package day02

import readInput

fun main() {

    fun mapRPCToPoint(input: String): Int {
        when (input) {
            "X" -> return 1
            "Y" -> return 2
            "Z" -> return 3
            else -> print("input is invalid")
        }

        return -100000
    }

    fun mapResultToPoint(input: String): Int {
        when (input) {
            "X" -> return 0
            "Y" -> return 3
            "Z" -> return 6
            else -> print("input is invalid")
        }

        return -100000
    }

    fun shapeScore(opponent:String, you:String): Int {
        /**
         * there is gotta be a better way to do this
         */
        if (opponent == "A") {
            return when (you) {
                "X" -> mapRPCToPoint("Z")
                "Y" -> mapRPCToPoint("X")
                "Z" -> mapRPCToPoint("Y")
                else -> -100000
            }
        }

        if (opponent == "B") {
            return when (you) {
                "X" -> mapRPCToPoint("X")
                "Y" -> mapRPCToPoint("Y")
                "Z" -> mapRPCToPoint("Z")
                else -> -100000
            }
        }

        if (opponent == "C") {
            return when (you) {
                "X" -> mapRPCToPoint("Y")
                "Y" -> mapRPCToPoint("Z")
                "Z" -> mapRPCToPoint("X")
                else -> -100000
            }
        }

        return -100000
    }

       fun matchScore(opponent:String, you:String): Int {
           /**
            * there is gotta be a better way to do this
            */
           if (opponent == "A") {
               return when (you) {
                   "X" -> 3
                   "Y" -> 6
                   "Z" -> 0
                   else -> -100000
               }
           }

           if (opponent == "B") {
               return when (you) {
                   "X" -> 0
                   "Y" -> 3
                   "Z" -> 6
                   else -> -100000
               }
           }

           if (opponent == "C") {
               return when (you) {
                   "X" -> 6
                   "Y" -> 0
                   "Z" -> 3
                   else -> -100000
               }
           }

           return -100000
       }

    fun calculateScore(input: String): Int {
        val result = input.split(" ")
        val opponent = result.get(0)
        val you = result.get(1)
        return mapRPCToPoint(you) + matchScore(opponent, you)
    }

    fun calculateScore2(input: String): Int {
        val result = input.split(" ")
        val opponent = result.get(0)
        val you = result.get(1)
        return mapResultToPoint(you) + shapeScore(opponent, you)
    }

    fun calculateTotalScores(input: List<String>): Int {
        return input.map { round ->
            calculateScore(round)
        }.sum()
    }

    fun calculateTotalScores2(input: List<String>): Int {
        return input.map { round ->
            calculateScore2(round)
        }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day02/Day02_test")
    println(calculateTotalScores(testInput))
    check(calculateTotalScores(testInput) == 15)
    println(calculateTotalScores2(testInput))
    check(calculateTotalScores2(testInput) == 12)

    val input = readInput("day02/Day02")
    println(calculateTotalScores(input))
    println(calculateTotalScores2(input))
}