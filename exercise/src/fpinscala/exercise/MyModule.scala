package fpinscala.exercise

import scala.annotation.tailrec
import scala.math.abs

object MyModule {

    def factorial(n: Int): Int = {
        @tailrec
        def go(n: Int, acc: Int): Int = {
            if (n <= 0) acc
            else go(n - 1, n * acc)
        }

        go(n, 1)
    }

    private def formatAbs(x: Int) = {
        val msg = "The absolute value of %d is %d."
        msg.format(x, abs(x))
    }

    private def formatFactorial(n: Int) = {
        val msg = "The factorial of %d is %d."
        msg.format(n, factorial(n))
    }


    def main(args: Array[String]): Unit = {
        println(formatAbs(-42))
        println(formatFactorial(7))
    }
}
