package com.example.navcomponenttestcontacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navcomponenttestcontacts.databinding.FragmentContactsBinding

class ContactsFragment : Fragment(R.layout.fragment_contacts) {

    lateinit var binding: FragmentContactsBinding
    private lateinit var adapter: ContactAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentContactsBinding.bind(view)
        var recyclerView: RecyclerView = binding.recyclerView

        val contacts: List<Contact> = listOf(
            Contact("Дима", "Иванов", R.drawable.avatart_user_1),
            Contact("Максим", "",R.drawable.avatar_user_2),
            Contact("Денис", "Куртуков",R.drawable.avatar_user_3),
            Contact("Лена", "",R.drawable.avatar_user_4),
            Contact("Настя", "Якимова",R.drawable.avatar_user_5)
        )
        adapter = ContactAdapter{onItemClick(contacts[it])}
        adapter.contacts = contacts
        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun onItemClick(contact: Contact) {
       var avatar: Int = contact.avatarResourceId
       var firstName: String = contact.firstName
       var secondName: String = contact.lastName
        findNavController().navigate(
            R.id.action_contactsFragment_to_contactFragment,
            bundleOf(
                ContactFragment.AVATAR to avatar,
                ContactFragment.FNAME to firstName,
                ContactFragment.SNAME to secondName
            )
        )
    }
}