package test

import main.Spellchecker
import main.buildDictionaryFromFile
import org.junit.jupiter.api.Test
import org.assertj.core.api.KotlinAssertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpellcheckerTests {
  val dictionary = buildDictionaryFromFile("input.txt")
  val spellchecker = Spellchecker(dictionary)
  var word = ""

  @BeforeAll
  fun `assign word`() {
    for (wrd in dictionary) {
      if (wrd.length > 2) {
        word = wrd
        print(wrd)
        break
      }
    }
  }

  @Test
  fun `write correct word`() {
    assertThat(spellchecker.getSuitableWords(word)).isEmpty()
  }

  @Test
  fun `missed second letter`() {
    val w = word[0] + word.substring(2)

    assertThat(spellchecker.getSuitableWords(w)).contains(word)
  }

  @Test
  fun `extra last letter`() {
    assertThat(spellchecker.getSuitableWords(word + 'g')).contains(word)
  }

  @Test
  fun `swaped first and second letters`() {
    val w = word[1] + word[0].toString() + word.substring(2)

    assertThat(spellchecker.getSuitableWords(w)).contains(word)
  }

  @Test
  fun `wrong first letter`() {
    val a = ((word[0] + 1).toInt() % 'a'.toInt() + 'a'.toInt()).toChar()
    val w = a + word.substring(1)

    assertThat(spellchecker.getSuitableWords(w)).contains(word)
  }
}