package com.scaler.imguram.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.scaler.imguram.databinding.ListItemStoryHeadBinding
import com.scaler.imguram.ui.story.StoryActivity
import com.scaler.libimgur.models.Tag

class StoriesRecyclerAdapter :
    ListAdapter<Tag, StoriesRecyclerAdapter.StoriesViewHolder>(StoriesDiffCallback()) {

    class StoriesViewHolder(val binding: ListItemStoryHeadBinding) :
        RecyclerView.ViewHolder(binding.root)

    private class StoriesDiffCallback : DiffUtil.ItemCallback<Tag>() {
        override fun areItemsTheSame(oldItem: Tag, newItem: Tag) = (oldItem == newItem)

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Tag, newItem: Tag) = (oldItem === newItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemStoryHeadBinding.inflate(inflater, parent, false)
        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val tag = getItem(position)
        holder.binding.storyHeadTextView.text = tag.displayName
        holder.binding.storyHeadImageView.load("https://i.imgur.com/${tag.backgroundHash}.jpg")
        holder.binding.root.apply {
            setOnClickListener {
                context.startActivity(
                    Intent(context, StoryActivity::class.java).apply {
                        putExtra("tag", tag.name)
                    }
                )
            }
        }
    }
}