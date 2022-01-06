import kotlin.jvm.JvmStatic

object StringTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val test = "am bm  cm"
        println(test.replace(" ", "_"))
    }
}