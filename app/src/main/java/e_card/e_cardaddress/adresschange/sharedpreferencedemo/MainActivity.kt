package e_card.e_cardaddress.adresschange.sharedpreferencedemo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import e_card.e_cardaddress.adresschange.sharedpreferencedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var session: LoginPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        session = LoginPref(this)

        if (session.isLoggedIn()) {
            var i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }
        binding.signUp.setOnClickListener {
            var username = binding.emailEdt.text.toString().trim()
            var email = binding.passwordEdt.text.toString().trim()

            if (username.isEmpty() && email.isEmpty()) {
                Toast.makeText(this, "Retry" + username + email, Toast.LENGTH_SHORT).show()

            } else {
                session.createLoginSession(username, email)
                var i = Intent(applicationContext, Login::class.java)
                startActivity(i)
                finish()
            }

        }
    }
}