package tech.zzhaodev.ktml.element

class Comment(private val content: String): Element {
    override fun render(indent: Int): String {
        val indentString = BaseElement.buildIndent(indent)
        return "$indentString<!-- $content -->"
    }
}