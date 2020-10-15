package eslam.emad.roompagination.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import eslam.emad.roompagination.R
import eslam.emad.roompagination.databinding.BookItemBinding
import eslam.emad.roompagination.model.BookEntity
import eslam.emad.roompagination.util.Constants.differCallback

class BookAdapter: PagedListAdapter<BookEntity, BookAdapter.MyViewHolder>(differCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: BookItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.book_item,
            parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.book = getItem(position)
    }

    class MyViewHolder(var binding: BookItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

}