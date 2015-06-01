class Rational(x: Int, y: Int){
  require(y != 0,"denominator must be greater than 0")
  def num = x
  def den = y

  def add(that : Rational) : Rational = {
    new Rational(num*that.den + that.num*den,den*that.den)
  }

  override def toString = {
    num +"/" + den
  }
}

val rational: Rational = new Rational(1,2)
rational.add(new Rational(1,2))

// IllegalArgumentException: denominator must be greater than 0
//new Rational(2,0)