package code.with.cal.netflix.fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import code.with.cal.netflix.R
import code.with.cal.netflix.data.ViewModel
import code.with.cal.netflix.data.ValueSharedPreferences
import code.with.cal.netflix.databinding.FragmentRegisterProfileBinding

class RegisterProfileFragment : Fragment(R.layout.fragment_register_profile) {

    private lateinit var registerProfileBinding: FragmentRegisterProfileBinding

    //private var picture: Bitmap = R.drawable.user_icon.toDrawable().toBitmap()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref =
            activity?.getSharedPreferences(ValueSharedPreferences.NAME_FILE, Context.MODE_PRIVATE)
        val sharedPrefEditor = sharedPref?.edit()

        checkRegister()

        registerProfileBinding = FragmentRegisterProfileBinding.bind(view)

        val takePicture =
            registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { result ->
                registerProfileBinding.imageviewUser.setImageBitmap(result)
                //picture = profileBinding.imageviewUser.drawable.toBitmap()
            }

        val findPicture =
            registerForActivityResult(ActivityResultContracts.GetContent()) { result ->
                registerProfileBinding.imageviewUser.setImageURI(result)
                //picture = profileBinding.imageviewUser.drawable.toBitmap()
            }

        registerProfileBinding.buttonOpenCamera.setOnClickListener {
            takePicture.launch()
        }

        registerProfileBinding.buttonOpenFile.setOnClickListener {
            findPicture.launch("image/*")
        }

        registerProfileBinding.buttonRegister.setOnClickListener {
            var fullname = ""
            var email = ""
            var username = ""

            if (registerProfileBinding.edittextFullname.text?.isEmpty() == true) {
                registerProfileBinding.edittextFullname.error =
                    "لطفا نام و نام خانوادگی خود را وارد کنید"
            } else {
                registerProfileBinding.edittextFullname.text.also { fullname = it.toString() }
                Log.i("AppText", fullname)
            }

            if (registerProfileBinding.edittextEmail.text?.isEmpty() == true) {
                registerProfileBinding.edittextEmail.error = "لطفا ایمیل خود را وارد کنید"
            } else {
                registerProfileBinding.edittextEmail.text.also { email = it.toString() }
                Log.i("AppText", email)
            }

            if (registerProfileBinding.edittextUsername.text?.isEmpty() == true) {
                registerProfileBinding.edittextUsername.error = "لطفا نام کاربری خود را وارد کنید"
            } else {
                username = registerProfileBinding.edittextUsername.text.toString()
                Log.i("AppText", username)
            }

            if (
                fullname.isNotEmpty() &&
                email.isNotEmpty() &&
                username.isNotEmpty()
            ) {
//                sharedPrefEditor?.putString(ValueSharedPreferences.PICTURE_ID,picture)
                sharedPrefEditor?.putString(
                    ValueSharedPreferences.FULL_NAME_ID,
                    registerProfileBinding.edittextFullname.text.toString()
                )
                sharedPrefEditor?.putString(
                    ValueSharedPreferences.EMAIL_ID,
                    registerProfileBinding.edittextEmail.text.toString()
                )
                sharedPrefEditor?.putString(
                    ValueSharedPreferences.USER_NAME_ID,
                    registerProfileBinding.edittextUsername.text.toString()
                )

                sharedPrefEditor?.apply()

                ViewModel().isRegister = true

                activity?.supportFragmentManager?.commit {
                    replace(R.id.fragment_container_main, ProfileFragment())
                    setReorderingAllowed(true)
                }

                Toast.makeText(activity, "ورود با موفقیت انجام شد", Toast.LENGTH_SHORT).show()

            }

        }

    }

    private fun checkRegister() {
        var sharedPref =
            activity?.getSharedPreferences(ValueSharedPreferences.NAME_FILE, Context.MODE_PRIVATE)

        try {
            if (sharedPref == null)
                sharedPref = activity?.getSharedPreferences(
                    ValueSharedPreferences.NAME_FILE,
                    Context.MODE_PRIVATE
                )

            ViewModel().isRegister = true

            val fullname = sharedPref?.getString(ValueSharedPreferences.FULL_NAME_ID, "")
            val password = sharedPref?.getString(ValueSharedPreferences.EMAIL_ID, "")
            val username = sharedPref?.getString(ValueSharedPreferences.USER_NAME_ID, "")

            if (
                fullname != null && fullname != "" ||
                username != null && username != "" ||
                password != null && password != ""
            ) {
                activity?.supportFragmentManager?.commit {
                    replace(R.id.fragment_container_main, ProfileFragment())
                    setReorderingAllowed(true)
                }
            }
        } catch (e: Exception) {
            Log.i("App", e.toString())
        }
    }

}