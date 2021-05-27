
// 문자열과 일치하는 부분 함수
val pf1: PartialFunction[Any, String] = {
    case s: String => "Yes"
}

// Double 과 일치하는 부분 함수
val pf2: PartialFunction[Any, String] = {
    case d: Double => "Yes"
}

// 문자열과 일치 하거나 Double 과 일치하는 부분 함수
val pf = pf1 orElse pf2

def tryPF(x: Any, f: PartialFunction[Any, String]): String =
    try {
        f(x).toString
    }
    catch {
        case _: MatchError => "Error!"
    }

def d(x: Any, f: PartialFunction[Any, String]) =
    f.isDefinedAt(x).toString
