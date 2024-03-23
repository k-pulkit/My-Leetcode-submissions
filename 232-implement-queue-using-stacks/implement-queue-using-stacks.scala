import scala.collection.mutable.ArrayBuffer

class MyQueue() {

    private var _store:ArrayBuffer[Int] = ArrayBuffer.empty[Int]

    def push(x: Int): Unit = {
        _store.append(x)
    }

    def pop(): Int = {
        _store.remove(0)
    }

    def peek(): Int = {
        _store(0)
    }

    def empty(): Boolean = {
        _store.size == 0
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * val obj = new MyQueue()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.peek()
 * val param_4 = obj.empty()
 */