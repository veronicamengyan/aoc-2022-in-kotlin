package day04

/**
 * Potential improvement:
 * * split on both , and -
 * * use IntRange
 */
import readInput
    fun main() {
        fun isContain(input: String): Boolean {
            val pair = input.split(",")
            val sections1 = pair[0].split("-")
            val sections2 = pair[1].split("-")
            val start1 = sections1[0].toInt()
            val end1 = sections1[1].toInt()
            val start2 = sections2[0].toInt()
            val end2 = sections2[1].toInt()

            return (start1 >= start2 && end1 <= end2) || (start1 <= start2 && end1 >= end2)
        }
        fun isOverlap(input: String): Boolean {
            val pair = input.split(",")
            val sections1 = pair[0].split("-")
            val sections2 = pair[1].split("-")
            val start1 = sections1[0].toInt()
            val end1 = sections1[1].toInt()
            val start2 = sections2[0].toInt()
            val end2 = sections2[1].toInt()

            return (end2 in start1..end1) || (end1 in start2..end2)
        }
        fun findContain(input: List<String>): Int {
            return input.count { item -> isContain(item)}
        }

        fun findOverlap(input: List<String>): Int {
            return input.count { item -> isOverlap(item)}
        }

        // test if implementation meets criteria from the description, like:
        val testInput = readInput("day04/Day04_test")
        println(findContain(testInput))
        check(findContain(testInput) == 2)

        println(findOverlap(testInput))
        check(findOverlap(testInput) == 4)

        val input = readInput("day04/Day04")
        println(findContain(input))
        println(findOverlap(input))
    }