import java.util.Comparator
import java.util.PriorityQueue

fun main() {
    fun findMaxCalories1(input: List<String>): Long {
        var maxCalories = 0L
        var currentCaloriesPerElf = 0L
        for(item in input) {
            if (item.isEmpty()) {
                if (currentCaloriesPerElf > maxCalories) {
                    maxCalories  = currentCaloriesPerElf
                }
                currentCaloriesPerElf = 0L
            } else {
                var calorie = item.toLong()
                currentCaloriesPerElf += calorie
            }

        }
        return maxCalories
    }

    fun findMaxCalories2(input: List<String>): Long {
        val myCustomComparator =  Comparator<Long> { a, b ->
            when {
                (a == b) -> 0
                (a > b) -> -1
                else -> 1
            }
        }
        val maxHeap = PriorityQueue<Long>(myCustomComparator)
        var currentCaloriesPerElf = 0L
        for(item in input) {
            if (item.isEmpty()) {
                maxHeap.add(currentCaloriesPerElf)
                currentCaloriesPerElf = 0L
            } else {
                var calorie = item.toLong()
                currentCaloriesPerElf += calorie
            }
        }

        maxHeap.add(currentCaloriesPerElf)

        val top1 = maxHeap.remove()
        val top2 = maxHeap.remove()
        val top3 = maxHeap.remove()

        return top1 + top2 + top3
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    println(findMaxCalories1(testInput))
    check(findMaxCalories1(testInput) == 24000L)

    println(findMaxCalories2(testInput))
    check(findMaxCalories2(testInput) == 45000L)

    val input = readInput("Day01")
    println(findMaxCalories2(input))
}
