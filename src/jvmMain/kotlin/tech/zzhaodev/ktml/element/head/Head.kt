package tech.zzhaodev.ktml.element

import tech.zzhaodev.ktml.element.single.Meta

class Head(private val pageTitle: String): BaseElement("head") {
    init {
        append(BaseElement("title", pageTitle))
    }
    fun meta(name: String, content: String) : Meta {
        val meta = Meta()
        meta.apply {
            name(name)
            content(content)
        }
        this.append(meta)
        return meta
    }

    fun meta(charset: String): Meta {
        val meta = Meta()
        meta.apply {
            charset(charset)
        }
        this.append(meta)
        return meta
    }
}