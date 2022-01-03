import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Main{

  /// task 6


    def main(args: Array[String]) = {

      //1
      val daysOfaWeek:List[String] = List("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")

      // the days of the week which starts with "S"
      val daysWithS=daysOfaWeek.filter(_.startsWith("S"))

      //1a for loop
      println("1a for loop : "+ (commaSep(daysOfaWeek)))

      //1b for loop
      println("1b for loop started S elements : "+commaSep(daysWithS))

      //1c 	while loop
      println("1c while loop : "+commaSepWL(daysOfaWeek))

      //1c 	while loop with S
      println("1c while loop started S elements : "+commaSepWL(daysWithS))

      //2a recursive
      println("2a recursive : "+commaSepRec(daysOfaWeek))

      //2b recursive
      println("2b recursive the last to the first : "+commaSepRecLastToFirst(daysOfaWeek))

      //3 tail recursive
      println("3 tail recursive : "+commaSepTailRec(daysOfaWeek))


      //4a foldLeft
      println("4a foldLeft : "+commaSepFoldL(daysOfaWeek))

      //4b foldRight
      println("4b foldRight : "+commaSepFoldR(daysOfaWeek))

      //4c foldLeft days with S
      println("4c foldLeft days with S : "+commaSepFoldLDaysWithS(daysOfaWeek))

      //5. map

      val products=Map("orange"->5,"apple"->6,"eggplant"->2,"chocolate"->4,"onion"->1)

      val productsDiscounted=products.map { case (key, value) => (key, value / 1.1)}

      println("5 products and price after discount :" + productsDiscounted )


      //6

      val listOfInt=List(-6,-5,-1,0,2,5,6,8,12,14,15)

      println("6 increase by 1 "+increaseByOne(listOfInt))

      //7

      println("7 abs <-5,12> "+task7(listOfInt))

      //8
      task8((8,"Eren","Yalcin"))


      //9

      println("7 abs <-5,12> "+ task9(listOfInt))


      //10 option

      var cMessage:Option[String] = None

      // If null
      println(cMessage.getOrElse("No message"))

      cMessage= Some("Hello")

      // If not null
      println(cMessage.getOrElse("No message"))

      ///
      val employee = Employee(2, "Bernie Sanders", None, 3)
      println(employee.gender.getOrElse("Not specified"))

      val resOpt = EmployeeDB.findEmployeeById(1)
      if (resOpt.isDefined)
        println(resOpt.get.name) //Prints Bernie Sanders

      val employeex = Employee(2, "Bernie Sanders", None, 3)
      employee.gender match {
        case Some(gender) => println(gender)
        case None => println("Not specified")
      }


    }


    def commaSep(days:List[String]):String={
      // for loop
      var daysCommaSep:String="";

      for(day:String<-days){
        if(daysCommaSep=="")
        daysCommaSep=day
        else
          daysCommaSep+=","+day
      }
      daysCommaSep;
    }


  def commaSepWL(days:List[String]):String={
    // while loop
    var daysCommaSep:String="";

    val iterator = days.listIterator()

    while(iterator.hasNext) {
      if (daysCommaSep == "")
        daysCommaSep = iterator.next()
      else
        daysCommaSep += "," + iterator.next()
    }
    daysCommaSep;
  }

  def commaSepRec(days:List[String]):String= {
    // recursive

    def addDay(i: Int ): String = {

      if(i< days.length-1)
        days.get(i) + "," + addDay(i + 1)
      else
        days.get(i)
    }
     addDay(0)

  }

  def commaSepRecLastToFirst(days:List[String]):String= {
    // recursive last to first

    def addDay(i: Int ): String = {

      if(i>0)
        days.get(i) + "," + addDay(i -1)
      else
        days.get(i)
    }

    addDay(days.length-1)

  }

  def commaSepTailRec(days:List[String]):String={
    /// tail recursive
    var daysCommaSep=""
    @tailrec
    def addDay(i:Int,result:String):String={
      var  day:String=""

      if(i==days.length) return  result

      if(i< days.length-1)
        day= days.get(i)+","
       else
        day =  days.get(i)

      addDay(i+1,result+day)
    }

    addDay(0,"")

  }


  def commaSepFoldL(days:List[String]):String= {
    // Foldleft

    val daysCommaSep= days.foldLeft(""){(acc:String,currDay:String)=>

      var sum:String=""

      if(acc=="")
        sum = currDay
      else
        sum=acc+","+currDay
      sum;

    }
    daysCommaSep;
  }

  def commaSepFoldR(days:List[String]):String= {
    // FoldRight

    val daysCommaSep= days.foldRight(""){(acc:String,currDay:String)=>

      var sum:String=""

      if(currDay=="")
        sum = acc
      else
        sum=acc+","+currDay
      sum;

    }
    daysCommaSep;

  }


  def commaSepFoldLDaysWithS(days:List[String]):String= {
   
    // foldLDaysWithS

    val daysCommaSep= days.filter(_.startsWith("S")).fold(""){(acc:String,currDay:String)=>

      var sum:String=""

      if(acc=="")
        sum = currDay
      else
        sum=acc+","+currDay
      sum;

    }
    daysCommaSep;

  }

  def increaseByOne(list: List[Int]):List[Int]={
  /// task 6
    val newList=list.map(x=>x+1)

    return newList;

  }

  def task7(list: List[Int]):List[Int]={
    // task7
    val newList=list.filter(_ >= -5).filter(_ < 12).map(_.abs)

    return newList;

  }

  def task8(tuple:(Any,Any,Any))={

    println("8 tuple first element "+tuple._1)
    println("8 tuple second element "+tuple._2)
    println("8 tuple third element "+tuple._3)

  }

  def task9(list:List[Any]):List[Any]={

    def iter(index: Int, currentList: List[Any]): List[Any] = {

      if (index >= currentList.length) return currentList;

      val (part1, part2) = currentList.splitAt(index)

      if (currentList.get(index) == 0)
        iter(index + 1, part1 ++ part2.tail)
      else
        iter(index + 1, currentList)
    }

    iter(0, list)

  }


  case class Employee (
                        id: Int,
                        name: String,
                        gender: Option[String],
                        tenure: Int
                      )
  object EmployeeDB {
    private val employees = Map(
      1 -> Employee(1, "Joe Biden", Some("Male"), 5),
      2 -> Employee(2, "Bernie Sanders", None, 3)
    )

    def findEmployeeById(id: Int) : Option[Employee] = {
      employees.get(id)
    }
  }

}

