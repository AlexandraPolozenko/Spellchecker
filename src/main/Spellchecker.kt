package main

import java.util.*

class Spellchecker(private val dictionary: HashSet<String>) {
  /*
    read word to check from console
   */
  fun runSpellchecker() {
    val w = readLine()!!.toLowerCase()

    if (dictionary.contains(w)) {
      println("Written correctly")
    } else {
      println("Possible variants:")

      getSuitableWords(w).forEach { i -> println(i) }
    }
  }

  /*
    run spellchecker
   */
  fun getSuitableWords(w: String): ArrayList<String> {
    val wrd = w.toLowerCase()

    if (dictionary.contains(wrd)) {
      return arrayListOf()
    }

    val variants = addLetter(wrd)
    variants.addAll(removeLetter(wrd))
    variants.addAll(substituteLetter(wrd))
    variants.addAll(switchLetters(wrd))

    val res = arrayListOf<String>()
    variants.forEach { i -> if (dictionary.contains(i)) res.add(i)}

    return res
  }

  fun addWordToDictionary(w: String) {
    dictionary.add(w)
  }

  /*
    returns all variants with one added character in every place in the word
   */
  private fun addLetter(w: String): ArrayList<String> {
    val res = arrayListOf<String>()

    for (i in 0 .. w.length) {
      val part1 = w.substring(0, i)
      val part2 = w.substring(i)

      for (j in 'a' .. 'z') {
        res.add(part1 + j + part2)
      }
    }

    return res
  }


  /*
   returns all variants with one removed character
   */
  private fun removeLetter(w: String): ArrayList<String> {
    val res = arrayListOf<String>()

    for (i in 0 until w.length) {
      res.add(w.removeRange(i, i + 1))
    }

    return res
  }

  /*
    returns all variants with one changed character
   */
  private fun substituteLetter(w: String): ArrayList<String> {
    val res = arrayListOf<String>()

    for (i in 0 until w.length) {
      val part1 = w.substring(0, i)
      val part2 = w.substring(i + 1)

      for (j in 'a' .. 'z') {
        val w1 = part1 + j + part2

        if (w1 != w) {
          res.add(w1)
        }
      }
    }

    return res
  }

  /*
    returns all variants with permutation of neighbour characters
   */
  private fun switchLetters(w: String): ArrayList<String> {
    val res = arrayListOf<String>()

    for (i in 0 until w.length - 1) {
      res.add(w.substring(0, i) + w[i + 1] + w[i] + w.substring(i + 2))
    }

    return res
  }
}