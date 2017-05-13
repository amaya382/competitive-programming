object Utils {
  def nextPermutation[T](buf: collection.mutable.Seq[T])(implicit o: Ordering[T]): Boolean = {
    import Ordering.Implicits._
    val size = buf.size
    val last = size - 1
    if (size < 2) {
      false
    } else {
      def go(i: Int = last): Boolean = {
        val x = i
        val y = i - 1
        if (buf(y) < buf(x)) {
          val z = buf.lastIndexWhere(el => buf(y) < el)
          val tmpY = buf(y)
          buf(y) = buf(z)
          buf(z) = tmpY
          (0 until (size - x) / 2).foreach(j => {
            val tmp = buf(last - j)
            buf(last - j) = buf(x + j)
            buf(x + j) = tmp
          })
          true
        } else if (y == 0) {
          (0 until size / 2).foreach(j => {
            val tmp = buf(last - j)
            buf(last - j) = buf(j)
            buf(j) = tmp
          })
          false
        } else {
          go(y)
        }
      }
      go()
    }
  }
}
