package com.example.bankingapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bankingapp.R
import database.UserEntity
import database.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.buttonInsert.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val name = editTextName.text.toString()
        val email = editTextEmail.text.toString()
        val amount = editTextAmount.text
        if(inputCheck(name,email,amount)){
            val userEntity=UserEntity(name, email, Integer.parseInt(amount.toString()))
            mUserViewModel.addUser(userEntity)
            Toast.makeText(requireContext(),"Successfully Added!",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Please Fill Out Again!",Toast.LENGTH_LONG).show()
        }
    }
    private fun inputCheck(name: String, email: String, amount: Editable):Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(email) && amount.isEmpty())
    }


   }
