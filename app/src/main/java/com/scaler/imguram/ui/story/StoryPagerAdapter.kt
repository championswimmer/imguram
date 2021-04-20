package com.scaler.imguram.ui.story

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import com.scaler.imguram.databinding.PageItemStoryBinding
import com.scaler.libimgur.models.Image

class StoryPagerAdapter() :
    ListAdapter<Image, StoryPagerAdapter.StoryPageViewHolder>(StoryDiffCallback()) {

    class StoryPageViewHolder(val binding: PageItemStoryBinding) : RecyclerView.ViewHolder(binding.root)

    class StoryDiffCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image) =
            oldItem == newItem

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image) =
            oldItem === newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryPageViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = PageItemStoryBinding.inflate(inflater, parent, false)
        return StoryPageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryPageViewHolder, position: Int) {
        val image = getItem(position)
        val imgUrl = if (image?.isAlbum == true && image.imagesCount != 0) {
            image.images!![0].link!!
        } else {
            image.link
        }

        imgUrl?.let {
            holder.binding.storyImageView.load(imgUrl)
            holder.binding.imageUrlTextView.text = imgUrl
        }
    }
}