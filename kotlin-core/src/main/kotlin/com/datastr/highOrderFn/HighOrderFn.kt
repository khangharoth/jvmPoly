package com.datastr.highOrderFn


fun applyTwice(fn: (Int) -> Int, number: Int): Int {
    return fn.invoke(fn.invoke(number))
}

