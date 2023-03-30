package com.example.mylibrary.model

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

class CampaignCategories : ArrayList<CampaignCategories.CampaignCategoriesItem>(){
    @Serializable
    data class CampaignCategoriesItem(
        @SerializedName("CampaignCategoriesID")
        val campaignCategoriesID: Int,
        @SerializedName("CampaignCategoryIcon")
        var campaignCategoryIcon: String,
        @SerializedName("CampaignCategoryName")
        val campaignCategoryName: String,
        @SerializedName("CampaignCategoryStatus")
        val campaignCategoryStatus: Boolean,
        @Contextual()
        var campaignCategoryIconDrawable: Drawable?,
        var isSelected: Boolean,
    )
}