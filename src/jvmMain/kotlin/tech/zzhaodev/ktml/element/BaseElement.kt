package tech.zzhaodev.ktml.element

/**
 * Base implementation of Interface [Element]
 *
 * @param tagName       The name of HTML tag
 * @param innerText     The inner text of this element. The same as `HTMLElement.innerText` in DOM.
 * @property children   The child elements of this element.
 * @property attribute  The attributes of this element. The key is name and the value is the value of the attribute.
 * */
open class BaseElement(private val tagName: String, var innerText: String = "") : Element{
    private val children = ArrayList<Element>()
    private val attribute = HashMap<String, String>()

    companion object {
        /**
         * @param indent The count of indent
         * @return An indent string
         * */
        fun buildIndent(indent: Int): String {
            val indentBuilder = StringBuilder()

            repeat(indent) {
                indentBuilder.append(" ")

            }
            return indentBuilder.toString()
        }
    }

    override fun render(indent: Int): String {
        val indentString = buildIndent(indent)
        val builder = StringBuilder().append(indentString)

        // start a tag
        builder.append("<$tagName")
        // set attributes
        attribute.forEach { (key, value) ->
            builder.append(""" ${key}="$value"""")
        }
        builder.append(">")

        // render children elements
        if (children.size > 0) {
            builder.append("\n")
        }
        // does not guarantee the order of the children elements
        children.forEach { element ->
            builder.append(element.render(indent + 4)).append("\n")
        }

        // innerText is appended after children elements
        if (innerText != "")
        builder.append(indentString).append(innerText).append("\n")

        // end a tag
        if (children.size > 0) {
            builder.append(indentString)
        }
        builder.append("</${tagName}>")

        return builder.toString()

    }

    fun append(child: Element) {
        this@BaseElement.children.add(child)
    }

    /**
     * @param name The name of the attribute
     * @param value the value of the attribute
     * */
    private fun setAttribute(name: String, value: String) {
        if (this@BaseElement.attribute.containsKey(name)) {
            this@BaseElement.attribute.replace(name, value)
        } else {
            this@BaseElement.attribute[name] = value
        }
    }

    operator fun set(name: String, value: String) {
        setAttribute(name, value)
    }

    fun comment(content: String): Comment {
        val comment = Comment(content)
        this.append(comment)
        return comment
    }
}
