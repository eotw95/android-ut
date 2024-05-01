package com.eotw95.androidutsample

class InputChecker {
    fun isValid(text: String?): Boolean {
        if (text == null) return false
        if (text.length < 3) {
            println("length")
            return false
        }
        return text.matches(Regex("[a-zA-Z0-9]+"))
    }
}