package day03
import readInput
import splitToListOfList

/**
 * Potential improvement:
 * * use chunked instead of splitToListOfList
 * * use extension class
 */
fun main() {
    fun findItemsScore(input: String): Int {
        val firstBag = input.substring(0, input.length/2).toSet()
        val secondBag = input.substring(input.length/2).toSet()
        return firstBag.intersect(secondBag).sumOf { item ->
            when (item.isUpperCase()) {
                true -> item - 'A' + 27
                false -> item - 'a' + 1
            }
        }
    }
    fun findBadgeScore(input: List<String>): Int {
        val firstElf = input[0].toSet()
        val secondElf = input[1].toSet()
        val thirdElf = input[2].toSet()
        return firstElf.intersect(secondElf).intersect(thirdElf).sumOf { item ->
            when (item.isUpperCase()) {
                true -> item - 'A' + 27
                false -> item - 'a' + 1
            }
        }
    }
    fun findBackpackItem1(input: List<String>): Int {
        return input.sumOf { item ->
            findItemsScore(item)
        }
    }

    fun findBackpackItem2(input: List<String>): Int {
        return splitToListOfList(input).sumOf { item ->
            findBadgeScore(item)
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day03/Day03_test")
    println(findBackpackItem1(testInput))
    check(findBackpackItem1(testInput) == 157)

    println(findBackpackItem2(testInput))
    check(findBackpackItem2(testInput) == 70)

    val input = readInput("day03/Day03")
    println(findBackpackItem1(input))
    println(findBackpackItem2(input))
}
