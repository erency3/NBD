object Main {

  ///task 9

  def main(args: Array[String]) = {

    val con = new Container[String]("containervalue")

    println(con.getContent())
    println(con.applyFunction[String](hello))

    val yes = new Yes[String]("avalue")
    val no = new No


    println(yes.isInstanceOf[Maybe[_]])
    println(no.isInstanceOf[Maybe[_]])

    println(yes.getOrElse("novalue"))
    println(no.getOrElse("novalue"))

  }

  def hello(s: String): String = {
    "Hello "+s
  }


}