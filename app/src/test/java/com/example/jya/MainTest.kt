package com.example.jya

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.jya.api.response.response.IssueResponse
import com.example.jya.ui.MainActivity
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

class MainTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()


    private val item: Item = Item(IssueResponse())

    private val itemListObserver = mockk<Observer<ArrayList<IssueResponse>>>()


    @Test(expected = NullPointerException::class)
    fun nextScreenTest(){
        val testMain = MainActivity()
        testMain.launchNextScreen(item)
    }

    @Test(expected = NullPointerException::class)
    fun setListTest(){
        val testMain = MainActivity()
        val mockItemList: ArrayList<IssueResponse> = ArrayList()
        mockItemList.add(IssueResponse())
        mockItemList.add(IssueResponse())
        testMain.setItemList(mockItemList)

        verify { itemListObserver.onChanged(mockItemList) }
    }

    @Test(expected = NullPointerException::class)
    fun clickFirstItemTest(){
        val testMain = MainActivity()
        val mockItemList: ArrayList<IssueResponse> = ArrayList()
        mockItemList.add(IssueResponse())
        mockItemList.add(IssueResponse())
        testMain.setItemList(mockItemList)
        testMain.onItemClick(0)
    }

    @Test(expected = NullPointerException::class)
    fun clickLastItemTest(){
        val testMain = MainActivity()
        val mockItemList: ArrayList<IssueResponse> = ArrayList()
        mockItemList.add(IssueResponse())
        mockItemList.add(IssueResponse())
        testMain.setItemList(mockItemList)
        testMain.onItemClick(mockItemList.size-1)
    }

}