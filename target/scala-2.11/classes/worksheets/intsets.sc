// abstract classes can not be instantiated
abstract class IntSet{
  def include(x: Int) : IntSet
  def contains(x: Int) : Boolean
  def union(other : IntSet) : IntSet
}

object Empty extends IntSet {
  override def include(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  override def contains(x: Int): Boolean = false

  override def toString = "."

  override def union(other: IntSet): IntSet = other
}

class NonEmpty(elem: Int, leftSubTree: IntSet, rightSubTree: IntSet) extends IntSet{
  override def include(x: Int): IntSet = {
    if(x < elem) new NonEmpty(elem, leftSubTree.include(x), rightSubTree)
    if(x > elem) new NonEmpty(elem, leftSubTree, rightSubTree.include(x))
    else this
  }

  override def contains(x: Int): Boolean = {
    if (x < elem) leftSubTree.contains(x)
    if (x > elem) rightSubTree.contains(x)
    else true
  }

  override def toString = "{"+ leftSubTree + elem + rightSubTree +"}"

  override def union(other: IntSet): IntSet =
    ((leftSubTree union rightSubTree) union(other)) include(elem)
}

val tree = new NonEmpty(3, Empty, Empty)
tree include 5