package id.sharekom.xenditexercise.views.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.sharekom.xenditexercise.databinding.ItemHomeBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private var listData: ArrayList<String> = ArrayList()
    private lateinit var onItemClickListener: OnItemClickListener

    fun setData(listData: ArrayList<String>) {
        this.listData = listData
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listData[position], onItemClickListener)
    }

    override fun getItemCount(): Int = listData.size

    inner class HomeViewHolder(private val binding : ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String, onItemClickListener: OnItemClickListener) {
            binding.tvData.text = data
            binding.root.setOnClickListener{
                onItemClickListener.onItemClicked(data)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(data: String)
    }
}