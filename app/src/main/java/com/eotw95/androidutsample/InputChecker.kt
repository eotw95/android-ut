package com.eotw95.androidutsample

class InputChecker {
    fun isValid(text: String?): Boolean {
        if (text == null) throw (IllegalArgumentException("Cannot be null"))
        if (text.length < 3) return false
        return text.matches(Regex("[a-zA-Z0-9]+"))
    }
}