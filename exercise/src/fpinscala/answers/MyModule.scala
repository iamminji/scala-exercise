package fpinscala.answers

import scala.annotation.tailrec

object MyModule {

    def fib(n: Int): Int = {
        @tailrec
        def go(i: Int, prev: Int, cur: Int): Int = {
            if (i >= n) prev
            else go(i + 1, cur, prev + cur)
        }

        go(0, 0, 1)
    }

    def main(args: Array[String]): Unit = {
        println(fib(5))
        println(fib(0))
        println(fib(1))
    }
}
