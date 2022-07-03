package com.example.navcomponenttestcontacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.navcomponenttestcontacts.databinding.FragmentContactBinding
import com.example.navcomponenttestcontacts.databinding.FragmentContactsBinding

class ContactFragment : Fragment(R.layout.fragment_contact) {

    companion object  {
        const val AVATAR = "avatar"
        const val FNAME = "fName"
        const val SNAME = "sName"
    }

    lateinit var binding: FragmentContactBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentContactBinding.bind(view)

        var avatar = requireArguments().getInt(AVATAR)
        var firstName: String = requireArguments().get(FNAME) as String
        var secondName: String = requireArguments().get(SNAME) as String

        binding.avatar.setImageResource(avatar)
        binding.firstNameValue.setText(firstName)
        binding.secondNameValue.setText(secondName)
    }
}