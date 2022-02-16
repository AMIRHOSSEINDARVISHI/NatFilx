package code.with.cal.netflix.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import code.with.cal.netflix.R
import code.with.cal.netflix.data.ViewModel
import code.with.cal.netflix.data.ValueSharedPreferences
import code.with.cal.netflix.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var profileBinding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref =
            activity?.getSharedPreferences(ValueSharedPreferences.NAME_FILE, Context.MODE_PRIVATE)

        profileBinding = FragmentProfileBinding.bind(view)

        val appView = ViewModel()

        val fullName =
            sharedPref?.getString(ValueSharedPreferences.FULL_NAME_ID, "No FullName").toString()
        val email = sharedPref?.getString(ValueSharedPreferences.EMAIL_ID, "No Email").toString()
        val userName =
            sharedPref?.getString(ValueSharedPreferences.USER_NAME_ID, "No UserName").toString()

        profileBinding.textviewFullname.text = fullName
        profileBinding.textviewEmail.text = email
        profileBinding.textviewUsername.text = userName

        profileBinding.buttonLogout.setOnClickListener {
            val sharedPrefEditor = sharedPref?.edit()
            sharedPrefEditor?.clear()
            sharedPrefEditor?.apply()

            appView.isRegister = false

            activity?.supportFragmentManager?.commit {
                replace(R.id.fragment_container_main, RegisterProfileFragment())
                setReorderingAllowed(true)
            }

        }

    }

}