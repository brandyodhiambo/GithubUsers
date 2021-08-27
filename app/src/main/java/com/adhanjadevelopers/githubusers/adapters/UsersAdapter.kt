package com.adhanjadevelopers.githubusers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adhanjadevelopers.githubusers.databinding.RowUserBinding
import com.adhanjadevelopers.githubusers.models.UsersResponseItem
import com.bumptech.glide.Glide

class UsersAdapter : ListAdapter<UsersResponseItem, UsersAdapter.MyHolder>(MyDiffutil) {
    inner class MyHolder(private val binding: RowUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: UsersResponseItem?) {
            binding.userLogin.text = user?.login
            Glide.with(binding.gitHubImage)
                .load(user?.avatarUrl)
                .circleCrop()
                .into(binding.gitHubImage)
        }
    }

    object MyDiffutil : DiffUtil.ItemCallback<UsersResponseItem>() {
        override fun areItemsTheSame(
            oldItem: UsersResponseItem,
            newItem: UsersResponseItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: UsersResponseItem,
            newItem: UsersResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(RowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }
}