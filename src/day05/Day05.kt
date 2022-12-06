package day05

import java.lang.StringBuilder
import java.util.ArrayDeque
import readInput

fun main() {
    fun findTopCrates(input: List<String>): String {
        var top = mutableListOf<String>()
        val bottom = mutableListOf<String>()
        var isInstruction = false;
        for(item in input) {
            if(item.isEmpty()) {
                isInstruction = true
                continue
            }
            if (!isInstruction) {
                top.add(item)
            } else {
                bottom.add(item)
            }
        }

        val numbers = top.takeLast(1).get(0)
        top = top.subList(0, top.size-1)
        val numberOfStack = numbers.substring(numbers.length-1, numbers.length).toInt()
        val stacks = MutableList(numberOfStack){ArrayDeque<String>()}
        for (item in top) {
            item.chunked(4).forEachIndexed{
                idx, value ->
                if (value.substring(1,2).isNotBlank()) {
                    stacks[idx].push(value.substring(1,2))
                }
            }
        }
        for (item in bottom) {
            val matches = Regex("\\d+").findAll(item).toList()
            repeat(matches[0].value.toInt()) {
                stacks[matches[2].value.toInt()-1].add(stacks[matches[1].value.toInt()-1].removeLast())
            }
        }
        val result = StringBuilder()
        stacks.forEach{ stack -> result.append(stack.peekLast())}
        return result.toString()
    }

    fun findTopCrates2(input: List<String>): String {
        var top = mutableListOf<String>()
        val bottom = mutableListOf<String>()
        var isInstruction = false;
        for(item in input) {
            if(item.isEmpty()) {
                isInstruction = true
                continue
            }
            if (!isInstruction) {
                top.add(item)
            } else {
                bottom.add(item)
            }
        }

        val numbers = top.takeLast(1).get(0)
        top = top.subList(0, top.size-1)
        val numberOfStack = numbers.substring(numbers.length-1, numbers.length).toInt()
        val stacks = MutableList(numberOfStack){ArrayDeque<String>()}
        for (item in top) {
            item.chunked(4).forEachIndexed{
                    idx, value ->
                if (value.substring(1,2).isNotBlank()) {
                    stacks[idx].push(value.substring(1,2))
                }
            }
        }
        for (item in bottom) {
            val matches = Regex("\\d+").findAll(item).toList()
            val local = mutableListOf<String>()
            repeat(matches[0].value.toInt()) {
                local.add(stacks[matches[1].value.toInt()-1].removeLast())
            }
            stacks[matches[2].value.toInt()-1].addAll(local.reversed())
        }
        val result = StringBuilder()
        stacks.forEach{ stack -> result.append(stack.peekLast())}
        return result.toString()
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day05/Day05_test")
    println(findTopCrates(testInput))
    check(findTopCrates(testInput) == "CMZ")

    println(findTopCrates2(testInput))
    check(findTopCrates2(testInput) == "MCD")

    val input = readInput("day05/Day05")
    println(findTopCrates(input))
    println(findTopCrates2(input))
}