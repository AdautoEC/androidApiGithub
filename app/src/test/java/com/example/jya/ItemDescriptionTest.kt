package com.example.jya

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.jya.api.response.response.IssueResponse
import com.example.jya.ui.ItemDescriptionActivity
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList

class ItemDescriptionTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val testItemDescription: ItemDescriptionActivity = ItemDescriptionActivity()
    private val item: Item = Item(IssueResponse())


    @Test(expected = NullPointerException::class)
    fun nextScreenTest(){

        testItemDescription.launchScreen(item)
    }
}