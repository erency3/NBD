
object Main {
  ///task 8

  def main(args: Array[String]) = {

    // Task1
    println("====>  task 1")
    var day:String="Monday"
    println(workOrWeekend(day))
    day="Saturday"
    println(workOrWeekend(day))
    day="Blabla"
    println(workOrWeekend(day))


    /// task 2 test
    println("====>  task 2")
    val bankAccount = new BankAccount()
    bankAccount.deposit(80)
    bankAccount.withdraw(35)
    bankAccount.withdraw(120)
    println(bankAccount.toString)

    // task 3
    println("====>  task 3")
    val person1 = new Persong("Alex","De Souza")
    val person2 = new Persong("Clark","Kent")
    val person3 = new Persong("Maria","de Lasazar")
   

    println(greeting(person1))
    println(greeting(person2))
    println(greeting(person3))


    println("====>  task 4")
    /// task4
    println(task4(5,double))


    ///task5


    println("====>  task 5")

       val prs1 = new Person("Clark", "Kent") with Student

       println(s"The student tax is: ${prs1.taxToPay}%")

       val prs2 = new Person("Maria", "Delasazar") with Employee

       println(s"The employee tax is  ${prs2.taxToPay}%")

       val prs3 = new Person("Alex", "De Souza") with Teacher
       println(s"The teacher tax is ${prs3.taxToPay}%")

       val prs4 = new Person("George", "Voudou") with Student with Employee
       println(s"The student,employee tax is ${prs4.taxToPay}%")

       val prs5 = new Person("Natasha", "White") with Employee with Student
       println(s"Employee, student tax is ${prs5.taxToPay}%")


  }

  def workOrWeekend(day:String):String={
    /// task1
    val workDays:List[String] = List("Monday","Tuesday","Wednesday","Thursday","Friday")
    val weekendDays:List[String]=List("Saturday","Sunday")


   var wkk:String= day match {
     case day:String if( workDays.contains(day)) =>  "work"
     case day:String if( weekendDays.contains(day)) => "weekend"
     case _ => "no such day"

   }

    return wkk;

  }



  class BankAccount{
    /// task2
    private var balance = 0

    def deposit(amount: Int): Unit = {
      if (amount > 0) balance = balance + amount
    }

    def withdraw(amount: Int): Int = {
      if (0 < amount && amount <= balance) {
        balance = balance - amount
        balance
      } else

        println("insufficient funds")

      balance
    }

    override def toString = {
      "Your balance is $"+balance
    }

  }

  /// task 3
  case class Persong(val firstName:String,val lastName:String){}

  def greeting(person:Persong):String  = {

    val gr= person.lastName match {
      case lastname if(firstName.contains("Alex"))=>"Mr. "+person.lastName+" welcome"
      case lastname if(lastname.contains("K"))=>"hi "+person.firstName
      case _ => "Hello "+person.lastName

    }
    gr;
  }

  /// task4
  def task4(a:Int,f: (Int) => Int):Int={
    var x=a

    for (i <- 1 to 3) {
      x=f(x)
    }
    return x;
  }

  def double(num:Int):Int={
    num*2;
  }




}
