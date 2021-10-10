package ru.ar2code.mutableliveevent

open class EventArgs<out T>(private val content: T?) : Event() {

    val data: T?
        get() {
            return if (handled) {
                null
            } else {
                content
            }
        }
}
