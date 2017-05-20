import java.{util => ju}
import scala.collection.{mutable => mu}
import MyPredef._


object Main extends App {
    val H,W = nextLong
    var h=Math.min(H,W)
    var w=Math.max(H,W)

    val res = if(h%3==0||w%3==0){
        0
    }else{
        var res = h

        (Math.max(w/3,0) to Math.min(w,w/3+1)).foreach(x => {
            val wx = w-x
            val h0 = h/2
            val h1 = h-h/2
            val can = Seq(x*h,wx*h0,wx*h1)
            res = Math.min(res,can.max-can.min)
        })

        (Math.max(h/3,0) to Math.min(h,h/3+1)).foreach(x => {
            val hx = h-x
            val w0 = w/2
            val w1 = w-w/2
            val can = Seq(x*w,hx*w0,hx*w1)
            res = Math.min(res,can.max-can.min)
        })

        res
    }

    println(res)
}


object MyPredef {
  @inline def rep(n: Int, f: => Unit): Unit = { var c = 0; while (c < n) { f; c += 1 } }
  @inline def rep(n: Int, f: Int => Unit): Unit = { var c = 0; while (c < n) { f(c); c += 1 } }

  private val buf = new Array[Byte](1024); private var ptr = 0; private var len = 0
  @inline private def isPrintableChar(c: Int): Boolean = 33 <= c && c <= 126
  @inline private def hasNextByte(): Boolean =
    if (ptr >= len) { ptr = 0; len = System.in.read(buf); len > 0 } else { true }
  @inline private def hasNext(): Boolean = {
    while (hasNextByte() && !isPrintableChar(buf(ptr))) ptr += 1
    hasNextByte()
  }
  @inline private def readByte(): Byte =
    if (hasNextByte()) { val res = buf(ptr); ptr += 1; res } else { -1 }
  def next(): String = {
    if(!hasNext()) ???
    val sb = new StringBuilder; var b = readByte()
    while (isPrintableChar(b)) { sb.append(b.toChar); b = readByte() }
    sb.toString
  }
  def nextInt(): Int = {
    val n = nextLong()
    if (n < Int.MinValue || Int.MaxValue < n) ???
    n.toInt
  }
  def nextLong(): Long = {
    if(!hasNext()) ???
    var minus = false; var b = readByte()
    if (b == '-') { minus = true; b = readByte() }
    def go (b: Byte, n: Long = 0): Long =
      if ('0' <= b && b <= '9') { go(readByte(), n * 10 + b - '0') }
      else if (minus) { -n } else { n }
    go(b)
  }
  def nextDouble(): Double = next.toDouble
}
object MyArray {
  def fillT[T : scala.reflect.ClassTag](dimX: Int, dimY: Int)(f: => T): Array[Array[T]] = {
    val arrs = Array.ofDim[T](dimX, dimY)
    for {
      y <- (0 until dimY)
      x <- (0 until dimX)
    } {
      arrs(x)(y) = f
    }
    arrs
  }
}
