package test

import main.Spellchecker
import org.junit.jupiter.api.Test
import org.assertj.core.api.KotlinAssertions.assertThat

class SpellcheckerTests {
  val spellchecker = Spellchecker(hashSetOf("the", "then", "that"))

  @Test
  fun `correct word`() {
    assertThat(spellchecker.getSuitableWords("the")).isEmpty()
  }

  @Test
  fun `missed third letter`() {
    assertThat(spellchecker.getSuitableWords("thn")).contains("then")
  }

  @Test
  fun `extra last letter`() {
    assertThat(spellchecker.getSuitableWords("thatk")).contains("that")
  }

  @Test
  fun `swaped first and second letters`() {
    assertThat(spellchecker.getSuitableWords("hte")).contains("the")
  }

  @Test
  fun `wrong first letter`() {
    assertThat(spellchecker.getSuitableWords("jhen")).contains("then")
  }
}