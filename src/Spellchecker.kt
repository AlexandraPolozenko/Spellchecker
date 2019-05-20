class Spellchecker(private val dictionary: HashSet<String>) {
  fun getSuitableWords(w: String): ArrayList<String> {
    val variants = addLetter(w)
    variants.addAll(removeLetter(w))
    variants.addAll(substituteLetter(w))
    variants.addAll(switchLetters(w))

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
      for (j in 0 until 26) {
        val a = ('a' + j)

        res.add(w.substring(0, i) + a + w.substring(i))
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
      for (j in 0 until 26) {
        val a = 'a' + j
        val w1 = w.substring(0, i) + a + w.substring(i + 1)

        if (w1 != w) {
          res.add(w.substring(0, i) + a + w.substring(i + 1))
        }
      }
    }

    return res
  }

  /*
    returns all variants with permutation of neighbor characters
   */
  private fun switchLetters(w: String): ArrayList<String> {
    val res = arrayListOf<String>()

    for (i in 0 until w.length - 1) {
      res.add(w.substring(0, i) + w[i + 1] + w[i] + w.substring(i + 2))
    }

    return res
  }
}