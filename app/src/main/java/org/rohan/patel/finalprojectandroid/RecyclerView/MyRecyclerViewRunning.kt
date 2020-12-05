package org.rohan.patel.finalprojectandroid.RecyclerView

import kotlinx.android.synthetic.main.list_view.view.*
import org.rohan.patel.finalprojectandroid.R


// Rohan Patel - 991496523
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.rohan.patel.finalprojectandroid.Entity.RunningEntity
import org.rohan.patel.finalprojectandroid.Entity.SwimmingEntity

class MyRecyclerViewRunning(private var sampleList:List<RunningEntity>): RecyclerView.Adapter<MyRecyclerViewWeightLifting.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewWeightLifting.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_view,parent,false);
        itemView.setOnClickListener{
            Toast.makeText(itemView.logDate.context,"You have selected ",Toast.LENGTH_SHORT).show()
        }
        return MyRecyclerViewWeightLifting.MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyRecyclerViewWeightLifting.MyViewHolder, position: Int) {
        val currentItem = sampleList[position]
        holder.date.text = currentItem.date
        holder.textView1.text = ""+currentItem.distance+" KM"
        holder.textView2.text = ""+currentItem.speed+" Kmph"
        holder.textView3.visibility = View.GONE


    }

    override fun getItemCount() = sampleList.size
}