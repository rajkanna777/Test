package com.example.d4insight.model

import com.google.gson.annotations.SerializedName

data class DashboardData(
    @SerializedName("dahsboard")
    val dashboard: Dashboard,
    @SerializedName("home")
    val home: ScreenItem,
    @SerializedName("myorder")
    val myorder: ScreenItem,
    @SerializedName("profile")
    val profile: ScreenItem,
)

data class Dashboard(
    @SerializedName("type")
    val type: String,
    @SerializedName("children")
    val children: List<BottomNavItem>
)

data class BottomNavItem(
    @SerializedName("icon")
    val iconUrl: String,
    @SerializedName("label")
    val label: String,
    @SerializedName("screenId")
    val screenId: String
)

data class ScreenItem(
    @SerializedName("type")
    val type: String="",
    @SerializedName("children")
    val children: List<Item> = emptyList()
)

data class Item(
    @SerializedName("url")
    val url: String?,
    @SerializedName("type")
    val type: String,
    @SerializedName("text")
    val text: String?
)
