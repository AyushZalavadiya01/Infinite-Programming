package com.example.languagecourses.Utils

object ColorPicker {
    val colors = arrayOf(


        "#3EB9DF",
        "#3685BC",
        "#D36280",
        "#E44F55",
        "#FA8056",
        "#818BCA",
        "#7D659F",
        "#51BAB3",
        "#4FB66C",
        "#E3AD17",
        "#627991",
        "#EF8EAD",
        "#B5BFC6",

//        "#05445E",
//        "#189AB4",
//        "#75E6DA",
//        "#D4F1F4",
//        "#0C2D48",
//        "#64CCC5",
//        "#2E8BC0",
//        "#274472",
//        "#0E8388",
//        "#2E4F4F",
//        "#CBE4DE",
//        "#2C3333",
//        "#00ABB3"
    )
    var currentColorIndex = 0

    fun getColor(): String {
        currentColorIndex = (currentColorIndex + 1) % colors.size
        return colors[currentColorIndex]
    }
}