package com.example.mvvmpattern.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpattern.databinding.NoteItemBinding
import com.example.mvvmpattern.models.AppNote

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListNotes = emptyList<AppNote>()

    class MainHolder(itemBinding: NoteItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
        val nameNote: TextView = itemBinding.itemNoteName
        val textNote: TextView = itemBinding.itemNoteText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(NoteItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.textNote.text = mListNotes[position].text
        holder.nameNote.text = mListNotes[position].name
    }

    override fun getItemCount(): Int = mListNotes.size

    fun setList(list: List<AppNote>){
        mListNotes = list
        notifyDataSetChanged() //обновляем адаптер
    }

    override fun onViewAttachedToWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener{
            MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }
}