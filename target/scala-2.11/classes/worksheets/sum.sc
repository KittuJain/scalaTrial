def sum (f : Int => Int)(a: Int, b: Int) : Int = {
  def loop(a: Int, acc : Int) : Int = {
    if(a > b) acc
    else loop(a+1, f(a) + acc)
  }
  loop(a, 0)
}

val sumSquares = sum (x => x * x)(3, 5)
val sumCubes = sum (x => x * x * x)(3, 5)
val sumFactorials = sum (fact)(3, 5)

def fact(x : Int ) : Int = if(x == 0) 1 else fact(x -1)
