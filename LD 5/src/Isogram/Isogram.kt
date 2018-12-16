package Isogram

object Isogram {

    fun isIsogram(word: String) =
        !word
                .filter(Char::isLetter)
                .toLowerCase()
                .groupBy { it }
                .values.any {it.size > 1}
}
