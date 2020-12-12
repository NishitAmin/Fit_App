package project.st991497190.vishvakumar.RecyclerView
// Rohan Patel - 991496523
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_view.view.*
import project.st991497190.vishvakumar.Entity.RunningEntity
import project.st991497190.vishvakumar.R

class MyRecyclerViewRunning(private var sampleList:List<RunningEntity>): RecyclerView.Adapter<MyRecyclerViewRunning.MyViewHolderRunning>() {
    class MyViewHolderRunning(itemView: View): RecyclerView.ViewHolder(itemView){
        val date: TextView = itemView.logDate
        val textView1: TextView = itemView.tView1
        val textView2 : TextView = itemView.tView2
        val textView3 : TextView = itemView.tView3
        val btnDeleteLog : Button = itemView.btnDeleteLog
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderRunning {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_view,parent,false);
        val viewHolder = MyViewHolderRunning(itemView)
        itemView.setOnClickListener{v->
            Toast.makeText(itemView.logDate.context,"You have selected ",Toast.LENGTH_SHORT).show()
            var bundle = Bundle()
            bundle.putInt("exerciseType",1)
            Log.d("POS", "onCreateViewHolder: Adapter position is" +viewHolder.adapterPosition)
            Log.d("POS", "onCreateViewHolder: ID is" +sampleList[viewHolder.adapterPosition].id)
            bundle.putLong("exerciseId",sampleList[viewHolder.adapterPosition].id)

            v.findNavController()?.navigate(R.id.action_viewLogsFragment_to_addLogFragment,bundle);
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolderRunning, position: Int) {
        val currentItem = sampleList[position]
        holder.date.text = currentItem.date
        holder.textView1.text = ""+currentItem.distance+" KM"
        holder.textView2.text = ""+currentItem.speed+" Kmph"
        holder.textView3.visibility = View.GONE
    }

    override fun getItemCount() = sampleList.size
}