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

///** this will make day 1 solution a lot cleaner
// * stole the idea from https://github.com/ylegall/AOC-Kotlin
// */
//fun splitToListOfList(input: List<String>):List<List<String>> {
//    val block = mutableListOf<List<String>>()
//    val currentBlock = mutableListOf<String>()
//    for (item in input) {
//        if (item.isEmpty()) {
//            if (currentBlock.isNotEmpty()) {
//                block.add(currentBlock)
//                currentBlock.clear()
//            }
//        } else {
//            currentBlock.add(item)
//        }
//    }
//    if (currentBlock.isNotEmpty()) {
//        block.add(currentBlock)
//    }
//    return block
//}
