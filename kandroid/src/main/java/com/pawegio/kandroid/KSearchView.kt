package com.pawegio.kandroid

import android.widget.SearchView
import android.support.v7.widget.SearchView as SupportSearchView

/**
 * @author pawegio
 */
public fun SearchView.onQueryChange(query: (String) -> Unit) {
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextChange(q: String): Boolean {
            query(q)
            return false
        }

        override fun onQueryTextSubmit(q: String): Boolean {
            return false
        }
    })
}

public fun SearchView.onQuerySubmit(query: (String) -> Unit) {
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextChange(q: String): Boolean {
            return false
        }

        override fun onQueryTextSubmit(q: String): Boolean {
            query(q)
            return false
        }
    })
}

public fun SupportSearchView.onQueryChange(query: (String) -> Unit) {
    setOnQueryTextListener(object : SupportSearchView.OnQueryTextListener {
        override fun onQueryTextChange(q: String): Boolean {
            query(q)
            return false
        }

        override fun onQueryTextSubmit(q: String): Boolean {
            return false
        }
    })
}

public fun SupportSearchView.onQuerySubmit(query: (String) -> Unit) {
    setOnQueryTextListener(object : SupportSearchView.OnQueryTextListener {
        override fun onQueryTextChange(q: String): Boolean {
            return false
        }

        override fun onQueryTextSubmit(q: String): Boolean {
            query(q)
            return false
        }
    })
}