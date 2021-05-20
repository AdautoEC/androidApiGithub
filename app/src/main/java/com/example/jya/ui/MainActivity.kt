package com.example.jya.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jya.Item
import com.example.jya.ItemAdapter
import com.example.jya.R
import com.example.jya.UtilMethods
import com.example.jya.Constants.EXTRA_ITEM
import com.example.jya.api.ApiService
import com.example.jya.api.response.response.IssueResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    ItemAdapter.OnItemClickListener {
    var itemList = ArrayList<Item>()
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this

        issueApiCall()
    }

    override fun onItemClick(position: Int) {
        val clickedItem : Item = itemList[position]
        launchNextScreen(clickedItem)
    }

    private fun generateItemList(issueList: List<IssueResponse>): ArrayList<Item> {
        val list = ArrayList<Item>()

        for(issue in issueList) {
            val item = Item(issue)
            list += item
        }

        return list
    }

    fun setItemList(issueResponse: List<IssueResponse>){
        this.itemList = generateItemList(issueResponse)
        val adapter = ItemAdapter(itemList, this)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(mContext)
        recycler_view.setHasFixedSize(true)
    }

    fun launchNextScreen(item: Item){
        val intent = Intent(mContext, ItemDescriptionActivity::class.java)
        intent.putExtra(EXTRA_ITEM, item)
        startActivity(intent)
    }

    @SuppressLint("CheckResult")
    private fun issueApiCall(){
        if(UtilMethods.isConnectedToInternet(mContext)){
            val observable = ApiService.issueApiCall().getIssue()
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ issueResponse ->
                        setItemList(issueResponse)
                    }, { error ->
                        Log.v(getString(R.string.tag_issue_api_call), error.message.toString())
                    }
                    )
        }else{
            Log.v(getString(R.string.tag_issue_api_call), getString(
                R.string.error_msg_issue_api_call
            ))
        }
    }
}