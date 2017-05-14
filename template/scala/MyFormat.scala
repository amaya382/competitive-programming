object MyFormat {
  def double(x: Double, precision: Int): String = {
    var num = x
    val sb = new StringBuilder
    if (num < 0) {
      sb.append("-")
      num = -num
    }
    num += Math.pow(10, -precision) / 2
    sb.append(num.toLong)
    sb.append(".")
    num -= num.toLong
    (0 until precision).foreach(i => {
      num *= 10
      sb.append(num.toInt)
      num -= num.toInt
    })
    sb.toString
  }
}
