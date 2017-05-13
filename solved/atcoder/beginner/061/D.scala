import scala.collection.mutable._
object Main extends App {
  val N = Scanner.nextInt // |V|
  val M = Scanner.nextInt // |E|
  val G = Array.tabulate(N)(from => (from, ArrayBuffer.empty[(Int, Long)])) // [(from, [(to, weight)])]
  val V = Array.fill(N)(Long.MinValue / 2L); V(0) = 0L
  (0 until M).foreach(i => G(Scanner.nextInt - 1)._2 += ((Scanner.nextInt - 1, Scanner.nextLong)))
  for {
    _ <- 0 until N
    n <- G // (from, [(to, weight)])
    e <- n._2 // (to, weight)
  } {
    if (V(e._1) < V(n._1) + e._2) V(e._1) = V(n._1) + e._2
  }
  for {
    _ <- 0 until N
    n <- G // (from, [(to, weight)])
    e <- n._2 // (to, weight)
  } {
    if (V(e._1) < V(n._1) + e._2) {
      V(e._1) = V(n._1) + e._2
      if (e._1 == V.size - 1) {
        println("inf")
        sys.exit
      }
    }
  }
  println(V.last)
}

object Scanner {
  private val buf = new Array[Byte](1024)
  private var ptr = 0
  private var len = 0

  @inline private def isPrintableChar(c: Int): Boolean = 33 <= c && c <= 126
  @inline private def hasNextByte: Boolean = if (ptr >= len) {
      ptr = 0
      len = System.in.read(buf)
      len > 0
    } else {
      true
    }
  @inline private def hasNext: Boolean = {
    while (hasNextByte && !isPrintableChar(buf(ptr))) ptr += 1
    hasNextByte
  }
  @inline private def readByte: Byte = {
    if (hasNextByte) {
      val res = buf(ptr)
      ptr += 1
      res
    } else {
      -1
    }
  }

  def next: String = {
    if(!hasNext) ???
    val sb = new StringBuilder
    var b = readByte
    while (isPrintableChar(b)) {
      sb.append(b.toChar)
      b = readByte
    }
    sb.toString
  }
  def nextInt: Int = {
    val n = nextLong
    if (n < Int.MinValue || Int.MaxValue < n) ???
    n.toInt
  }
  def nextLong: Long = {
    if(!hasNext) ???
    var minus = false
    var b = readByte
    if (b == '-') {
      minus = true
      b = readByte
    }
    def go (b: Byte, n: Long = 0): Long =
      if ('0' <= b && b <= '9') go(readByte, n * 10 + b - '0')
      else if (minus) -n
      else n
    go(b)
  }
  def nextDouble: Double = next.toDouble
}
