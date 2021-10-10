package ru.ar2code.mutableliveevent

import androidx.lifecycle.Observer

class PendingObserver<T : Event>(val wrappedObserver: Observer<in T>) : Observer<T> {

    private var pending = false

    override fun onChanged(event: T?) {
        if (pending && event?.handled != true) {
            pending = false
            wrappedObserver.onChanged(event)
        }
    }

    fun awaitValue() {
        pending = true
    }
}
