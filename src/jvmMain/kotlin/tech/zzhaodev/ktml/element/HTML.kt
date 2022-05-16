package tech.zzhaodev.ktml.element

class HTML: BaseElement("html") {
    fun body(block: Body.() -> Unit): Body {
        val body = Body().apply {
            this.block()
        }
        this.append(body)
        return body
    }

    fun head(block: Head.() -> Unit): Head {
        val head = Head().apply {
            this.block()
        }
        this.append(head)
        return head
    }

}

fun html(block: HTML.() -> Unit): HTML {
    val html = HTML().apply {
        this.block()
    }
    return html
}