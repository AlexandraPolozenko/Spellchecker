package main

fun main(args: Array<String>) {
  val spellchecker = Spellchecker(buildDictionaryFromFile("input.txt"))

  spellchecker.runSpellchecker()
}
