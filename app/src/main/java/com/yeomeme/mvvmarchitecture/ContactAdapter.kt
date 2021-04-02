package com.yeomeme.mvvmarchitecture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**

 * Created by yeomeme@gmail.com on 2021-04-02
 *
 */
class ContactAdapter(val contactItemClick: (Contact) -> Unit, val contactItemLongClick: (Contact) -> Unit)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private var contact : List<Contact> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contact[position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            private val nameTv = itemView.findViewById<TextView>(R.id.item_tv_name)
            private val numberTv = itemView.findViewById<TextView>(R.id.item_tv_number)
            private val initialTv = itemView.findViewById<TextView>(R.id.item_tv_initial)

            fun bind(contact: Contact) {
            nameTv.text = contact.name
                numberTv.text = contact.name
                initialTv.text = contact.initial.toString()


                itemView.setOnClickListener {
                    contactItemClick(contact)
                }

                itemView.setOnLongClickListener {
                    contactItemLongClick(contact)
                    true
                }
            }
        }

    fun setContacts(contact: List<Contact>) {
        this.contact = contact
        notifyDataSetChanged()
    }

}