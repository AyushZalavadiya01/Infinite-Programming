package com.example.languagecourses.adapter

import android.media.browse.MediaBrowser
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.languagecourses.DataClass.Cprogramming
import com.example.languagecourses.databinding.ListItemBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView


@Suppress("DEPRECATION")
class MyAdapter(private val itemlist: ArrayList<Cprogramming>) :
    RecyclerView.Adapter<MyAdapter.custmAdpter>() {


    class custmAdpter(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): custmAdpter {
        return custmAdpter(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: custmAdpter, position: Int) {
        val image = itemlist[position].titleImage
        holder.binding.titleImage.setImageResource(image)
        holder.binding.tvTitle.text = itemlist[position].heading
        holder.binding.tvDescription.text = itemlist[position].desc

//        val videoView = itemlist[position].videoUrl
//        holder.binding.videoView.setVideoPath(videoView)

//        val videoUrl = itemlist[position] // Replace with your data source
//
//        // Initialize ExoPlayer and set it up here
//        val player = ExoPlayer.Builder(holder.itemView.context).build()
//        holder.playerView.player = player
//        holder.playerView.player?.stop()
//        holder.playerView.player?.release()
//
//
//        // Create a MediaItem for the video URL and set it to the player
//        val mediaItem = MediaItem.fromUri(videoUrl.videoUrl)
//        player.setMediaItem(mediaItem)
//        player.prepare()
//        player.play()

    }
}




