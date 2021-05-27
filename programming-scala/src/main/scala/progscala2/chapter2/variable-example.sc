
// array 는 다른 Array를 가리키도록 재할당할 수 없다.
val array: Array[String] = new Array(5)

// 대신 원소 변경은 가능함
array(0) = "Hello"
array
array(0) = "World"
array

// var 은 변경 가능함
var stockPrice: Double = 100.0
stockPrice = 200.0

// 하지만 stockPrices 가 가리키는 객체를 변경한 것은 아님 (Double 이 불변이니까)
