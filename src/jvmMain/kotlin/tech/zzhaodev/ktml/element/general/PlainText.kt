package tech.zzhaodev.ktml.element

class PlainText(val content: String): Element {
    override fun render(indent: Int): String {
        val indentString = BaseElement.buildIndent(indent)
        val builder = StringBuilder()
        builder.append(indentString).append(content)
        return builder.toString()
    }
}