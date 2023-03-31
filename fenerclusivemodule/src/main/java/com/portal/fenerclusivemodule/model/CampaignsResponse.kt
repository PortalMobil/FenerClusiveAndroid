package com.portal.fenerclusivemodule.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

class CampaignsResponse : ArrayList<CampaignsResponse.CampaignsResponseItem>(){
    @Serializable
    data class CampaignsResponseItem(
        @SerializedName("CampaignExtraDetailsImage")
        val campaignExtraDetailsImage: String,
        @SerializedName("CampaignTypeQuota")
        val campaignTypeQuota: Int,
        @SerializedName("CategoryIds")
        val CategoryIds: List<Int>,
        @SerializedName("Company")
        val company: String,
        @SerializedName("CompanyLogo")
        val companyLogo: String,
        @SerializedName("CompanyName")
        val companyName: String,
        @SerializedName("Description")
        val Description: String,
        @SerializedName("DocumentPublishFrom")
        val documentPublishFrom: String,
        @SerializedName("DocumentPublishTo")
        val documentPublishTo: String,
        @SerializedName("EndDate")
        val endDate: String,
        @SerializedName("FavoriteCount")
        val FavoriteCount: Int,
        @SerializedName("Id")
        val id: Int,
        @SerializedName("Image")
        val image: String,
        @SerializedName("IsFavorite")
        val isFavorite: Boolean,
        @SerializedName("IsJoined")
        val isJoined: Boolean,
        @SerializedName("IsSoonOver")
        val isSoonOver: Boolean,
        @SerializedName("IsSoonOverPrefix")
        val isSoonOverPrefix: String,
        @SerializedName("JoinedCount")
        val joinedCount: Int,
        @SerializedName("MemberTypeId")
        val memberTypeId: String,
        @SerializedName("RemainingTime")
        val remainingTime: String,
        @SerializedName("SpotDescription")
        val spotDescription: String,
        @SerializedName("SpotImage")
        val spotImage: String,
        @SerializedName("SpotTitle")
        val spotTitle: String,
        @SerializedName("StartDate")
        val startDate: String,
        @SerializedName("Title")
        val title: String,
        @SerializedName("Type")
        val type: String,
        @SerializedName("WebID")
        val webID: Int,
        @SerializedName("WorkerTypeId")
        val workerTypeId: String
    )
}