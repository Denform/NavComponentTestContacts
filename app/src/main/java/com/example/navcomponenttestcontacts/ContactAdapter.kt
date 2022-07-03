package com.example.navcomponenttestcontacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navcomponenttestcontacts.databinding.ContactItemBinding

class ContactAdapter(private val onItemClick: (Int) -> Unit):
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    var contacts: List<Contact> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ContactItemBinding = ContactItemBinding.inflate(inflater, parent, false)
        return  ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact:Contact = contacts[position]
        with(holder.binding) {
            Name.text = "${contact.firstName} ${contact.lastName}"
            avatar.setImageResource(R.drawable.ic_baseline_account_box_24)
        }

        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int = contacts.size

    class ContactViewHolder(
        val binding: ContactItemBinding
    ): RecyclerView.ViewHolder(binding.root)
}