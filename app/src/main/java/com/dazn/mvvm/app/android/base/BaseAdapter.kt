package com.dazn.mvvm.app.android.base

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class BaseAdapter<T>(
    private val coroutineScope: CoroutineScope
) {
    private val _items = mutableStateListOf<T>()
    val items: List<T> get() = _items

    /**
     * Update the list with new data.
     */
    fun submitList(newItems: List<T>) {
        _items.clear()
        _items.addAll(newItems)
    }

    /**
     * Add an item to the list with animation.
     */
    fun addItem(item: T) {
        _items.add(item)
    }

    /**
     * Remove an item from the list with animation.
     */
    fun removeItem(item: T) {
        _items.remove(item)
    }

    /**
     * Scroll smoothly to a specific position in the list.
     */
    fun smoothScrollToPosition(listState: LazyListState, position: Int) {
        coroutineScope.launch {
            listState.animateScrollToItem(position)
        }
    }
}