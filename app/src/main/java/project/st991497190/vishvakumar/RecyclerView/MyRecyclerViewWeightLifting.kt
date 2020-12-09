package project.st991497190.vishvakumar.RecyclerView

import android.app.AlertDialog
import kotlinx.android.synthetic.main.list_view.view.*


// Rohan Patel - 991496523
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import project.st991497190.vishvakumar.Entity.WeightLiftingEntity
import project.st991497190.vishvakumar.Database.FitDatabase
import project.st991497190.vishvakumar.R

class MyRecyclerViewWeightLifting(private var sampleList:List<WeightLiftingEntity>): RecyclerView.Adapter<MyRecyclerViewWeightLifting.MyViewHolder>() {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val date: TextView = itemView.logDate
        val textView1: TextView = itemView.tView1
        val textView2 : TextView = itemView.tView2
        val textView3 : TextView = itemView.tView3
        val btnDeleteLog : Button = itemView.btnDeleteLog
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_view,parent,false);
        itemView.setOnClickListener{
            Toast.makeText(itemView.logDate.context,"You have selected ",Toast.LENGTH_SHORT).show()
        }
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = sampleList[position]
        holder.date.text = currentItem.date
        holder.textView1.text = ""+currentItem.reps+" Reps"
        holder.textView2.text = ""+currentItem.sets+" Sets"
        holder.textView3.text = ""+currentItem.weight+" kg"
        holder.btnDeleteLog.setOnClickListener {v->


            val builder = AlertDialog.Builder(v.context)
            builder.setTitle("Delete Conformation")
            builder.setMessage("Are you sure you want to delete the log ?")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(v.context,
                    android.R.string.yes, Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(v.context,
                    android.R.string.no, Toast.LENGTH_SHORT).show()
            }

            builder.setPositiveButton("Yes") {_,_->
                Toast.makeText(v.context,
                    "Deleting log", Toast.LENGTH_SHORT).show()
                FitDatabase.getInstance(v.context).weightLiftingDao().delete(currentItem.id)
            }

            builder.setNegativeButton("No") {_,_->

                Toast.makeText(v.context,
                    "Not deleting log", Toast.LENGTH_SHORT).show()
            }

            builder.show()

        }

    }

    override fun getItemCount() = sampleList.size
}


//package org.rohan.patel.finalprojectandroid.RecyclerView
//
//import kotlinx.android.synthetic.main.list_view.view.*
//import org.rohan.patel.finalprojectandroid.R
//
//
//// Rohan Patel - 991496523
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import android.widget.Toast
//import androidx.recyclerview.widget.RecyclerView
//import project.st991497190.vishvakumar.Entity.WeightLiftingEntity
//
//class MyRecyclerViewWeightLifting(private var sampleList:List<WeightLiftingEntity>): RecyclerView.Adapter<MyRecyclerViewWeightLifting.MyViewHolder>() {
//    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        val date: TextView = itemView.logDate
//        val textView1: TextView = itemView.tView1
//        val textView2 : TextView = itemView.tView2
//        val textView3 : TextView = itemView.tView3
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_view,parent,false);
//        itemView.setOnClickListener{
//            Toast.makeText(itemView.logDate.context,"You have selected ",Toast.LENGTH_SHORT).show()
//        }
//        return MyViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val currentItem = sampleList[position]
//        holder.date.text = currentItem.date
//        holder.textView1.text = ""+currentItem.reps+" Reps"
//        holder.textView2.text = ""+currentItem.sets+" Sets"
//        holder.textView3.text = ""+currentItem.weight+" kg"
//
//
//    }
//
//    override fun getItemCount() = sampleList.size
//}