package com.scaler.imguram.ui.story

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.scaler.imguram.R
import com.scaler.imguram.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {

    private val storyViewModel by viewModels<StoryViewModel>()
    private lateinit var _binding: ActivityStoryBinding
    private val storyPagerAdapter = StoryPagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val tagName = intent.getStringExtra("tag")

        tagName?.let { storyViewModel.fetchTagGallery(it) }

        _binding.storyViewPager.adapter = storyPagerAdapter
    }

    override fun onResume() {
        super.onResume()

        storyViewModel.images.observe(this) {
            storyPagerAdapter.submitList(it)
        }
    }
}