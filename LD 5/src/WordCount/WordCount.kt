package WordCount

object WordCount {

    fun phrase(text: String) =
        text
            .split(Regex("""\W'|'\W|[^\w']+"""))
            .filter(String::isNotBlank)
            .groupingBy {it.toLowerCase()}
            .eachCount()
}
