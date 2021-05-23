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

    def findFirst(ss: Array[String], key: String): Int = {
        @tailrec
        def loop(n: Int): Int = {
            if (n >= ss.length) -1
            else if (ss(n) == key) n
            else loop(n + 1)
        }

        loop(0)
    }

    def findFirst[A](as: Array[A], p: A => Boolean): Int = {
        @tailrec
        def loop(n: Int): Int = {
            if (n >= as.length) -1
            else if (p(as(n))) n
            else loop(n + 1)
        }

        loop(0)
    }


    def main(args: Array[String]): Unit = {
        println(formatAbs(-42))
        println(formatFactorial(7))
        println(findFirst(Array("a", "b", "c", "d"), "b"))
        println(findFirst[Int](Array(1, 2, 3, 4), (x: Int) => x == 2))
    }

    // 인수가 2개인 함수 f 를 받아서 그것을 부분적으로 적용하는 함수
    def partial1[A, B, C](a: A, f: (A, B) => C): B => C = {
        (b: B) => f(a, b)
    }
}
