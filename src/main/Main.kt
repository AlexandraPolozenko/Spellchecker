package main

fun main(args: Array<String>) {
  val spellchecker = Spellchecker(buildDictionaryFromFile("dictionary.txt"))

  spellchecker.runSpellchecker()
}
