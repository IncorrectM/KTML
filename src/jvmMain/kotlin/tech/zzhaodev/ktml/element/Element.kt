package tech.zzhaodev.ktml.element

/**
 * Everything is an element in KTML
 * */
interface Element {
    /**
     * Render the element itself into HTML String
     * */
    fun render(indent: Int = 0): String
}