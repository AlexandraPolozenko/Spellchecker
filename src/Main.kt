fun main(args: Array<String>) {
  val spellchecker = Spellchecker(buildDictionaryFromFile("input.txt"))

  println(spellchecker.getSuitableWords("which"))
  println(spellchecker.getSuitableWords("clampd"))
  println(spellchecker.getSuitableWords("producingh"))
  println(spellchecker.getSuitableWords("meduim"))
  println(spellchecker.getSuitableWords("stok"))
  println(spellchecker.getSuitableWords("agake"))
}
