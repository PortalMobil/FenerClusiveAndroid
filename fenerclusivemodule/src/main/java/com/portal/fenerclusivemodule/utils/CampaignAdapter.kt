package com.portal.fenerclusivemodule.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.portal.fenerclusivemodule.R
import com.portal.fenerclusivemodule.model.CampaignsResponse
import kotlinx.android.synthetic.main.item_campaign.view.*


class CampaignAdapter(var itemList: List<CampaignsResponse.CampaignsResponseItem>) : RecyclerView.Adapter<CampaignAdapter.CampaignViewHolder>() {

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): CampaignViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val line = inflater.inflate(R.layout.item_campaign, parent, false)

        return CampaignViewHolder(line)
    }

    override fun onBindViewHolder(holder: CampaignViewHolder, position: Int) {
        val card = itemList[position]
        holder.setData(card, position)
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    class CampaignViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardItem = itemView as CardView

        fun setData(card: CampaignsResponse.CampaignsResponseItem, position: Int){

            cardItem.apply {
                tv_campaign_title.text = card.title
                tv_like_count.text = card.FavoriteCount.toString()
                Glide.with(this).load(card.image).placeholder(R.drawable.no_image).into(img_campaign)
                Glide.with(this).load(card.companyLogo).into(img_company_logo)

                img_like.setOnClickListener {
                    if (it.isSelected) {
                        it.isSelected = false
                        tv_like_count.text = (card.FavoriteCount).toString()

                    } else {
                        it.isSelected = true
                        tv_like_count.text = (card.FavoriteCount + 1).toString()
                    }

                }

                img_comment.setOnClickListener {
                    it.isSelected = !it.isSelected
                }
            }
        }

    }

}