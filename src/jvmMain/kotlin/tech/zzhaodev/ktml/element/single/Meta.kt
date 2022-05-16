package tech.zzhaodev.ktml.element.single

class Meta: SingleElement("meta") {
    private var charsetFlag = false
    fun name(value: String) {
        if (charsetFlag) {
            attribute.clear()
            charsetFlag = false
        }
        setAttribute("name", value)
        content("")
    }

    fun content(value: String) {
        if (charsetFlag) {
            attribute.clear()
            charsetFlag = false
        }
        setAttribute("content", value)
    }

    fun charset(value: String) {
        attribute.clear()
        charsetFlag = true
        setAttribute("charset", value)
    }
}