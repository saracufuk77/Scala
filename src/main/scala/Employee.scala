import com.sun.tools.javac.Main

class Employee (var name:String , var salary:Int){
  var dept =0
}

class TestFunction{
  def method (x:Int) =x+1    //method is field but
  val function = (x:Int) => x+1    //function is an object. use it in a functional context.
  val simpleStringFun = () => "Hi there!"
  val evenOrOdd = (x:Int) => {
    if(x%2==0)
      "even"
    else
      "odd"
  }

  val sumSalary = (empList: List[Employee]) =>{
    var sum =0
//    empList.foreach((e:Employee)=>sum+=e.salary)
    empList.foreach(e=>sum+=e.salary)
    sum
  }

  val sumSalaryDept = (empList: List[Employee]) => {
    var sum = 0
    empList.foreach(e => {
      if(e.dept==10)
        sum += e.salary
    })
    sum
  }

  val sumSalarySmart = (empList: List[Employee],selection: Employee=>Boolean) => {
    var sum = 0
    empList.foreach(e => {
      if (selection(e))
        sum += e.salary
    })
    sum
  }

}

object Main{
  def main(args: Array[String]): Unit = {
    val t= new TestFunction()
    println("Method Result is: "+t.method(10))
    println("Function Result is: "+t.function(10))
    println(t.simpleStringFun())
    println(t.evenOrOdd(11))

    var joe = new Employee("Joe",1000)
    joe.dept =10
    var ufuk = new Employee("Ufuk",5000)
    ufuk.dept= 11
    var ali = new Employee("Ali",4000)
    ali.dept = 10
    var john = new Employee("John",3500)
    john.dept = 11
    var eList=List(joe,ufuk,ali,john)
    println("Total salary of employees is: $"+t.sumSalary(eList))
    println("Total salary for dept 10 is: $"+t.sumSalaryDept(eList))
    println("Total salary of employees in dept 10 is: $"+t.sumSalarySmart(eList, (e: Employee) => e.dept == 10))
    println("Total salary of employees NOT in dept 10 is: $"+t.sumSalarySmart(eList, (e: Employee) => e.dept != 10))
    println("Total salary of employees NOT in dept 10 is: $"+t.sumSalarySmart(eList, e => e.dept != 10))
  }
}
