package br.com.kodigos.mysofie.Sofie.SofieList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.kodigos.mysofie.Model.SofieBody
import br.com.kodigos.mysofie.R

class SofieListAdapter (
    var mList: List<SofieBody>
) : RecyclerView.Adapter<SofieListAdapter.SofieListViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SofieListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.listview_sofie, parent, false)
        return SofieListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mList.count()
    }

    override fun onBindViewHolder(holder: SofieListViewHolder, position: Int) {
        val item = mList[position]
        holder.tarefaName.text = item.title
        holder.tarefaEmail.text = item.email

    }


    class SofieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tarefaName: TextView = itemView.findViewById(R.id.tarefaName)
        var tarefaEmail: TextView = itemView.findViewById(R.id.tarefaEmail)

    }

}