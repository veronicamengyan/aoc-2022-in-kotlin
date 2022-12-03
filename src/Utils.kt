import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt")
    .readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * stole the idea from https://github.com/ylegall/AOC-Kotlin
 */
fun splitToListOfList(input: List<String>): List<List<String>> {
    val block = mutableListOf<List<String>>()
    val currentBlock = mutableListOf<String>()
    for ((counter, item) in input.withIndex()) {
        if (counter % 3 == 2 ) {
            if (currentBlock.isNotEmpty()) {
                currentBlock.add(item)
                block.add(currentBlock.toList())
                currentBlock.clear()
            }
        } else {
            currentBlock.add(item)
        }
    }
    return block.toList()
}
