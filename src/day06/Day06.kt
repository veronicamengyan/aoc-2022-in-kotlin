package day06

import readInput

fun main() {
    fun findMarker(input: List<String>): Int {
        input.get(0).windowed(4, 1).forEachIndexed{
            idx, value ->
                if (value.length == value.toCharArray().toSet().size) {
                    return idx + 4
                }
        }
        return -10000
    }

    fun findMarker2(input: List<String>): Int {
        input.get(0).windowed(14, 1).forEachIndexed{
                idx, value ->
            if (value.length == value.toCharArray().toSet().size) {
                return idx + 14
            }
        }
        return -10000
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day06/Day06_test")
    val testInput2 = readInput("day06/Day06_test2")
    val testInput3 = readInput("day06/Day06_test3")
    val testInput4 = readInput("day06/Day06_test4")
    val testInput5 = readInput("day06/Day06_test5")
    check(findMarker(testInput) == 7)
    check(findMarker(testInput2) == 5)
    check(findMarker(testInput3) == 6)
    check(findMarker(testInput4) == 10)
    check(findMarker(testInput5) == 11)

    println(findMarker2(testInput))
    check(findMarker2(testInput) == 19)
    check(findMarker2(testInput2) == 23)
    check(findMarker2(testInput3) == 23)
    check(findMarker2(testInput4) == 29)
    check(findMarker2(testInput5) == 26)

    val input = readInput("day06/Day06")
    println(findMarker(input))
    println(findMarker2(input))
}