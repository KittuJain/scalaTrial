// Currying
def product (f : Int => Int) (a: Int, b : Int) : Int = {
  if(a > b) 1
  else f(a) * product(f) (a+1, b)
}

product(x => x * x * x)(3, 4)
def fact(n : Int) = product(x=>x)(1, n)
fact(5)

def reduce(f : Int => Int, initial : Int, combine : (Int, Int) => Int) (a: Int, b : Int) : Int = {
  if(a > b) initial
  else combine(f(a), reduce(f, initial, combine)(a+1, b))
}

reduce(x => x * x, 1, (a, b) => a * b)(3, 4)