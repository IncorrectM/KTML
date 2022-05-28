package tech.zzhaodev.ktml.element.single

import tech.zzhaodev.ktml.element.BaseElement
import tech.zzhaodev.ktml.element.Element

open class SingleElement(private val tagName: String): Element {
    protected val attribute = HashMap<String, String>()

    override fun render(indent: Int): String {
        val indentString = BaseElement.buildIndent(indent)
        val builder = StringBuilder()
        builder.append(indentString).append("<$tagName")
        attribute.forEach { (key, value) ->
            builder.append(" $key=\"$value\"")
        }
        builder.append(">")
        return builder.toString()
    }

    protected fun setAttribute(name: String, value: String) {
        if (this.attribute.containsKey(name)) {
            this.attribute.replace(name, value)
        } else {
            this.attribute[name] = value
        }
    }
}