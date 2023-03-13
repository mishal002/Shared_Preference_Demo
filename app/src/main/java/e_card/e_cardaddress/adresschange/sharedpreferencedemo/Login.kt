package e_card.e_cardaddress.adresschange.sharedpreferencedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import e_card.e_cardaddress.adresschange.sharedpreferencedemo.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    lateinit var session: LoginPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = LoginPref(this)

        session.chekLogin()
        var user: HashMap<String, String> = session.getUserDetails()

        var usename = user.get(LoginPref.KEY_USERNAME)
        var email = user.get(LoginPref.KEY_EMAIL)

        binding.usernameTxt.setText(usename)
        binding.emailTxt.setText(email)

        binding.logOutBtn.setOnClickListener {
            session.logoutUser()
        }

    }
}