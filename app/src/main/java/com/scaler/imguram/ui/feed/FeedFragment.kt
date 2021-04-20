package com.scaler.imguram.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import coil.Coil
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.scaler.imguram.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by viewModels()
    private val feedAdapter = FeedRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed") // TODO: turn into enum
        feed?.let { viewModel.updateFeed(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFeedBinding.inflate(inflater, container, false)
        binding.feedRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.feedRecyclerView.adapter = feedAdapter

        viewModel.feed.observe(viewLifecycleOwner) {
            it.forEach { image ->
                val request = ImageRequest.Builder(requireContext())
                    .data("https://i.imgur.com/${image.cover}.jpg")
                    // Optional, but setting a ViewSizeResolver will conserve memory by limiting the size the image should be preloaded into memory at.
                    .size(binding.feedRecyclerView.width)
                    .build()
                Coil.imageLoader(requireContext()).enqueue(request)
            }
            feedAdapter.submitList(it)
        }

        return binding.root
    }
}