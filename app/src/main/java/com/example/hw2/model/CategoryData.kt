package com.example.hw2.model

object CategoryData {
    fun getCategories() = listOf(
        Category(1, "food", mutableListOf("apple", "banana", "burger", "pizza")),
        Category(2, "tools", mutableListOf("hammer", "screwdriver", "drill")),
        Category(3, "countries", mutableListOf("Ukraine", "Poland", "USA", "France")))
}