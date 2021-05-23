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

    def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
        @tailrec
        def loop(i: Int, j: Int): Boolean = {
            if (j >= as.length) true
            else if (!ordered(as(i), as(j))) false
            else loop(i + 1, j + 1)
        }

        loop(0, 1)
    }

    // B => C 가 f:(A, B) => C 에서 이므로 C 를 f(a, b)
    // A => B => C 가 결국
    // (a: A) => (b: B) => f(a, b) 가 됨
    def curry[A, B, C](f: (A, B) => C): A => (B => C) = {
        (a: A) => (b: B) => f(a, b)
    }

    def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
        // TODO 솔직히 uncurry 는 잘 모르겠음
        (a: A, b: B) => f(a)(b)
    }

    // f 는 input 으로 B 를 받는데, g 의 output 이 B 임
    // 그래서 g 가 먼저 선수여야 한다고 이해함
    def compose[A, B, C](f: B => C, g: A => B): A => C = {
        (a: A) => f(g(a))
    }

    def main(args: Array[String]): Unit = {

        println(fib(5))
        println(fib(0))
        println(fib(1))

        println(isSorted(Array(1, 2, 3, 4), (x1: Int, x2: Int) => x1 <= x2))
        println(isSorted(Array(1, 3, 2, 1), (x1: Int, x2: Int) => x1 <= x2))
        println(isSorted(Array(5, 3, 2, 1), (x1: Int, x2: Int) => x1 >= x2))

        // add
        println(curry((x: Int, y: Int) => x + y)(1)(2))
        // mul
        println(curry((x: Int, y: Int) => x * y)(1)(2))

        // 2번째 인자값의 함수가 먼저 실행 됨
        // 3 * 3 + 2
        println(compose((x: Int) => x + 2, (y: Int) => y * 3)(3))
        // (3 + 3) * 2
        println(compose((x: Int) => x * 2, (y: Int) => y + 3)(3))

        // compose 와 비슷한 andThen example
        // 3 * 2 + 3
        val compose2 = ((x: Int) => x * 2) andThen ((y: Int) => y + 3)
        println(compose2(3))
    }
}
