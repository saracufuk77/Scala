class ShoppingCart (var product: String, var price:Double, var quantity:Int){
}
class functions{
  val sumShopping = (shopList: List[ShoppingCart])=>{
    var total = 0.0
    shopList.foreach(p=>total+=(p.quantity*p.price))
    total
  }
}
object shop {
  def main(args: Array[String]): Unit = {
    val f = new functions()

    var cheese = new ShoppingCart("Cheese", 4.99, 3)
    var meat = new ShoppingCart("Meat", 7.99, 5)
    var bread = new ShoppingCart("Bread", 1.99, 4)

    var cartItems = List(cheese, meat, bread)
    cartItems.foreach(item => println(s"${item.product}\t${item.price}\t${item.quantity}"))
    println("Total payment for this shopping cart is: $" + f.sumShopping(cartItems))
  }
}

