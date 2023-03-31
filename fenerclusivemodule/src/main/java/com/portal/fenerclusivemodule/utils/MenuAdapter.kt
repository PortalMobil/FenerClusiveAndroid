package com.portal.fenerclusivemodule.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.portal.fenerclusivemodule.R
import com.portal.fenerclusivemodule.model.CampaignCategories
import kotlinx.android.synthetic.main.item_menu.view.*

interface CategorySelectListener{
    fun categorySelected(id: Int)
}

class MenuAdapter(var itemList: List<CampaignCategories.CampaignCategoriesItem>, private var categorySelectListener: CategorySelectListener) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val line = inflater.inflate(R.layout.item_menu, parent, false)

        return MenuViewHolder(line, categorySelectListener)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menu = itemList[position]
        holder.setData(menu, position)
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    class MenuViewHolder(itemView: View, categorySelectListener: CategorySelectListener) : RecyclerView.ViewHolder(itemView) {
        var menuItem = itemView as CardView
        val categorySelectListener = categorySelectListener

        fun setData(menu: CampaignCategories.CampaignCategoriesItem, position: Int){

            menuItem.apply {
                img_menu.setImageDrawable(menu.campaignCategoryIconDrawable)
                img_menu.isSelected = menu.isSelected
                tv_menu.text = menu.campaignCategoryName
                tv_menu.isSelected = menu.isSelected
                layout.isSelected = menu.isSelected

                setOnClickListener {
                    categorySelectListener.categorySelected(menu.campaignCategoriesID)
                }
            }

        }

    }

}