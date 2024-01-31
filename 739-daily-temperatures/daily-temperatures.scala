import collection.mutable.Stack

object Solution {
    def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {

        // create an answers array
        val answers = Array.fill[Int](temperatures.length)(0)
        var stack = Stack.empty[Int]

        // I will use a monotonic stack for this
        // Iterate through each element
        for (i <- 0 until temperatures.length) {
            // If current element is greater than top of stack means, we have found an element greater than top as an answer
            if (!stack.isEmpty && temperatures(i) > temperatures(stack.top)) {
                // Keep looking for answers by popping
                while (!stack.isEmpty && temperatures(i) > temperatures(stack.top)) {
                    // save answers
                    answers(stack.top) = i - stack.top
                    stack.pop()
                }
                // push current after all answers have been saved
                stack.push(i)
            } else {
                // push if elem is not greater than top of stack
                stack.push(i)
            }
        }

        answers  

    }
}