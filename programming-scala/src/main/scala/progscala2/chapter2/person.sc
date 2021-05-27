
class Person(val name: String, var age: Int)
val p = new Person("hello", 20)
p.name
p.age
// error
// p.name = "World"
p.age = 30