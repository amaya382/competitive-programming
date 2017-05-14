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
