package com.example.webapp1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row.view.*
import java.util.*
import kotlin.collections.ArrayList as ArrayList1

class MainAdapter : RecyclerView.Adapter<MainAdapter.customViewHolder>() {

    val arrayListOfEmployees = ArrayList<Model.Companion.CustomModel>()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): customViewHolder {

        return customViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.row, p0, false))

    }

    override fun getItemCount(): Int {
        return arrayListOfEmployees.count()
    }

    override fun onBindViewHolder(viewHolder: customViewHolder, position: Int) {
        viewHolder.onBind(arrayListOfEmployees[position])
        viewHolder.itemView.setOnClickListener {
            println(" CLICKED ")

        }
    }

    fun setter(arr: ArrayList<Model.Companion.CustomModel>) {
        arrayListOfEmployees.addAll(arr)
        /*notifyDataSetChanged()*/

    }

    class customViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { //DOUBT
        fun onBind(employee: Model.Companion.CustomModel) {
            itemView.textView2.text=employee.id
            itemView.textView3.text=employee.name


        }
    }
}
