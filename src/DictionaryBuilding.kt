import java.io.File

fun buildDictionaryFromFile(filePath: String): HashSet<String> {
  val res = hashSetOf<String>()

  File(filePath).forEachLine {
    i -> res.addAll(i.filter {
      j -> (j.isLetter() || j.isWhitespace())
    }.split(" "))
  }

  return res
}