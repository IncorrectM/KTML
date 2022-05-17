import tech.zzhaodev.ktml.element.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ElementTest {
    @Test
    fun `test BaseElement render`() {
        val ele = BaseElement("div", "")
        ele["class"] = "container"
        assertEquals("""<div class="container"></div>""", ele.render())

    }

    @Test
    fun `test BaseElement render with multiple attributes`() {
        val ele = BaseElement("div", "")
        ele["class"] = "container"
        ele["v-for"] = "item in items"
        // BaseElement render does not guarantee the order of the attributes
        assertTrue {
            """<div class="container" v-for="item in items"></div>""" == ele.render() ||
                    """<div v-for="item in items" class="container"></div>""" == ele.render()
        }
    }

    @Test
    fun `test building html element`() {
        val htmlContent = html {
            head(title = "html test") {
                comment("设置元数据")
                meta("keywords", "Basic Page")
                meta("UTF-8")
            }
            body {

            }
        }
        assertEquals(
            """ #<html>
                #    <head>
                #        <title>
                #            html test
                #        </title>
                #        <!-- 设置元数据 -->
                #        <meta name="keywords" content="Basic Page">
                #        <meta charset="UTF-8">
                #    </head>
                #    <body>    </body>
                #</html>""".trimMargin("#")
            , htmlContent.render())
    }

    @Test
    fun `test plain text with indent`() {
        assertEquals("    Hello world!", PlainText("Hello world!").render(4))
    }

}
