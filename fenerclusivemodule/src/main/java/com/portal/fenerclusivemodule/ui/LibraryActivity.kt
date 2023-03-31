package com.portal.fenerclusivemodule.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.portal.fenerclusivemodule.model.CampaignCategories
import com.portal.fenerclusivemodule.model.CampaignsResponse
import com.portal.fenerclusivemodule.utils.CampaignAdapter
import com.portal.fenerclusivemodule.utils.CategorySelectListener
import com.portal.fenerclusivemodule.utils.MenuAdapter
import com.portal.fenerclusivemodule.utils.ServiceData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.portal.fenerclusivemodule.R
import kotlinx.android.synthetic.main.activity_library.*
import java.lang.reflect.Type

class LibraryActivity : AppCompatActivity(), CategorySelectListener {

    lateinit var menuAdapter: MenuAdapter
    lateinit var campaignAdapter: CampaignAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        supportActionBar?.hide()

        btn_back.setOnClickListener {
            onBackPressed()
        }

        btn_search.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("FenerClusive")
                .setMessage("FenerClusive")
                .setCancelable(true)
                .setPositiveButton("close"){ dialog, which ->
                    dialog.cancel()
                }.show()

        }

        menuAdapter = MenuAdapter(getMenuWithIcons(), this)
        rw_top_menu.adapter = menuAdapter
        campaignAdapter = CampaignAdapter(listOf())
        rw_campaign.adapter = campaignAdapter
        categorySelected(1)
    }

    private fun RecyclerView.addScrollListener(onScroll: (position: Int) -> Unit) {
        var lastPosition = 0
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (layoutManager is LinearLayoutManager) {
                    val currentVisibleItemPosition = (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                    if (lastPosition != currentVisibleItemPosition && currentVisibleItemPosition != RecyclerView.NO_POSITION) {
                        onScroll.invoke(currentVisibleItemPosition)
                        lastPosition = currentVisibleItemPosition
                    }
                }
            }
        })
    }

    private fun getMenuList() : List<CampaignCategories.CampaignCategoriesItem>{
        val listMenuType: Type = object : TypeToken<List<CampaignCategories.CampaignCategoriesItem>>() {}.type
        return Gson().fromJson(ServiceData.categories, listMenuType)
    }

    private fun getCardList() : List<CampaignsResponse.CampaignsResponseItem>{
        val listCardType: Type = object : TypeToken<List<CampaignsResponse.CampaignsResponseItem>>() {}.type
        return Gson().fromJson(ServiceData.campaings, listCardType)
    }

    private fun getMenuWithIcons() : List<CampaignCategories.CampaignCategoriesItem>{
        val list = getMenuList()
        list.forEach {
            it.campaignCategoryIconDrawable = when(it.campaignCategoriesID) {
                1 -> ContextCompat.getDrawable(this, R.drawable.star)
                2 -> ContextCompat.getDrawable(this, R.drawable.food)
                3 -> ContextCompat.getDrawable(this, R.drawable.pan)
                4 -> ContextCompat.getDrawable(this, R.drawable.clothes)
                5 -> ContextCompat.getDrawable(this, R.drawable.online_shopping)
                6 -> ContextCompat.getDrawable(this, R.drawable.automotive)
                7 -> ContextCompat.getDrawable(this, R.drawable.food_drink)
                8 -> ContextCompat.getDrawable(this, R.drawable.art)
                9 -> ContextCompat.getDrawable(this, R.drawable.trip)
                10 -> ContextCompat.getDrawable(this, R.drawable.lifestyle)
                11 -> ContextCompat.getDrawable(this, R.drawable.education)
                12 -> ContextCompat.getDrawable(this, R.drawable.support)
                13 -> ContextCompat.getDrawable(this, R.drawable.privilege)
                else -> ContextCompat.getDrawable(this, R.drawable.star)
            }
        }
        return  list
    }

    override fun categorySelected(id: Int) {
        val campaignList = getCardList().filter { it.CategoryIds.contains(id) }
        campaignAdapter.itemList = campaignList
        campaignAdapter.notifyDataSetChanged()

        menuAdapter.itemList.forEach {
            it.isSelected = it.campaignCategoriesID == id
        }
        menuAdapter.notifyDataSetChanged()

        if (campaignList.isEmpty()) {
            campaign_count.visibility = View.GONE
        } else {
            campaign_count.visibility = View.VISIBLE
            campaign_count.text ="1/ ${campaignList.size}"
        }

        rw_campaign.addScrollListener { position: Int ->
            campaign_count.text ="${position + 1} / ${campaignList.size}"
        }
    }

}