package com.example.proyectofinalkotlin.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.proyectofinalkotlin.R
import com.example.proyectofinalkotlin.classes.RestEngine
import com.example.proyectofinalkotlin.classes.UserDataCollectionItem
import com.example.proyectofinalkotlin.classes.UserMinorData
import com.example.proyectofinalkotlin.entities.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginBandAppFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login_band_app, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn_login = view.findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener { v ->
            callServiceGetUsers()

        }
    }

    private fun callServiceGetUsers() {
        val userService: UserService = RestEngine.getRestEngine().create(UserService::class.java)
        val result: Call<List<UserDataCollectionItem>> = userService.listUsers()
        result.enqueue(object : Callback<List<UserDataCollectionItem>> {
            override fun onResponse(
                call: Call<List<UserDataCollectionItem>>,
                response: Response<List<UserDataCollectionItem>>
            ) {
                val et_user_name: EditText = view!!.findViewById(R.id.et_user_name)
                val et_user_password: EditText = view!!.findViewById(R.id.et_user_password)
                response.body()?.forEach {
                    val user = it.data.email.toString()
                    val password = it.data.password.toString()
                    if (user == et_user_name.text.toString() && password == et_user_password.text.toString()) {
                        Toast.makeText(context, "Welcome ${it.data.firstname}", Toast.LENGTH_SHORT)
                            .show()
                        var userEmail:String= it.data.email
                        val bundle = bundleOf("userEmail" to userEmail)
                        findNavController().navigate(R.id.action_loginBandAppFragment_to_bookingFragment,bundle)
                    }
                }
            }

            override fun onFailure(call: Call<List<UserDataCollectionItem>>, t: Throwable) {
                Toast.makeText(context, "Connection Error, Try again later", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }



}