package com.example.mvvm.master

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MasterAdapter : RecyclerView.Adapter<MasterAdapter.MasterViewHolder>() {

    private val mData : MutableList<String> = mutableListOf()
    private lateinit var mListener : OnclickListener

    fun addData(data : List<String>?){
        if(data == null)
        {
            return
        }
        mData.addAll(data)
        notifyDataSetChanged()
    }

    fun setListener(onclickListener: OnclickListener)
    {
        mListener = onclickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasterViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_dropdown_item_1line,parent,false)
        return MasterViewHolder(view,mListener)
    }

    override fun getItemCount(): Int {
        return mData?.size
    }

    override fun onBindViewHolder(holder: MasterViewHolder, position: Int) {
        holder.bindData(mData[position])
    }


    inner class MasterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var textView: TextView
       lateinit var mListener: OnclickListener
        constructor(itemView: View, onclickListener: OnclickListener) : this(itemView){
            textView = itemView.findViewById(android.R.id.text1)
            mListener = onclickListener
            itemView.setOnClickListener { mListener.onClick(mData[adapterPosition]) }
       }

        fun bindData(name : String){
            if(TextUtils.isEmpty(name)){
                return
            }
            textView.text = name

        }
    }

    interface OnclickListener {
        fun onClick(result : String)
    }
}

