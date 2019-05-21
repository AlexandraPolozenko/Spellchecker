package main

import java.io.File
import java.util.*

fun buildDictionaryFromFile(filePath: String): HashSet<String> {
  val res = hashSetOf<String>()

  File(filePath).forEachLine {
    line ->
      res.addAll(line.filter {
        symb -> (symb.isLetter() || symb.isWhitespace() || (symb == '-'))
      }.toLowerCase().split(" "))
  }

  return res
}