package com.example.roomdemo.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.R
import com.example.roomdemo.databinding.RecyclerviewItemBinding
import com.example.roomdemo.model.Word

class WordListAdapter: ListAdapter<Word, WordListAdapter.WordViewHolder>(WordsComparator()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }

    class WordViewHolder private constructor (private val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(text: String?) {
            binding.textView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return WordViewHolder(binding)
            }
        }
    }
    class WordsComparator : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.word == newItem.word
        }
    }

}