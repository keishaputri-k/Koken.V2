package com.kei.kokenv2.ui.fragments.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.kei.kokenv2.R
import com.kei.kokenv2.ui.authentication.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), View.OnClickListener {
    var refUsers : DatabaseReference? = null
    var firebaseUser : FirebaseUser? = null

    companion object {
        fun getLaunchService (from: Context) = Intent(from, ProfileFragment::class.java).apply{
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        fun newInstance() =
            ProfileFragment().apply {
                arguments = Bundle().apply {}
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_logout.setOnClickListener(this)
        firebaseUser = FirebaseAuth.getInstance().currentUser
        refUsers = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser!!.uid)
        refUsers!!.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                for (p0 in snapshot.children){
                    val name = snapshot.child("fullName").value.toString()
                    val email = snapshot.child("email").value.toString()
                    val photo = snapshot.child("photo").value.toString()

                    tv_name_profile.text = name
                    tv_email_profile.text = email
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onClick(p0: View) {
        when(p0.id) {
            R.id.tv_logout -> logOut()
        }
    }

    private fun logOut() {
        val intent = Intent(activity, LoginActivity::class.java)
        activity?.startActivity(intent)
//        startActivity(Intent(
//            LoginActivity.getLaunchService(
//                activity
//            )
//        ))
        FirebaseAuth.getInstance().signOut()
    }
}