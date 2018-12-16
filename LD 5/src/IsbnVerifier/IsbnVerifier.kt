package IsbnVerifier

class IsbnVerifier {
    fun isValid(isbn: String) =
        isbn
            .apply { if (!matches(Regex("[0-9][-]?[0-9]{3}[-]?[0-9]{5}[-]?[0-9X]"))) return false }
            .let { it.replace("-", "") }
            .apply { if (length != 10) return false }
            .map { if (it == 'X') 10 else (it - '0') }
            .foldIndexed(0) { dec, sum, value -> sum + (value * (10 - dec)) } % 11 == 0
}
