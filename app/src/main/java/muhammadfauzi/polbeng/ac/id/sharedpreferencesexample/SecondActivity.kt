package muhammadfauzi.polbeng.ac.id.sharedpreferencesexample

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import muhammadfauzi.polbeng.ac.id.sharedpreferencesexample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val filename = "$packageName.TESTFILE"
        val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)

        binding.btnLoad.setOnClickListener {
            val firstName = pref.getString("firstName", "")
            val lastName = pref.getString("lastName", "")
            binding.tvOutput.text = "$firstName $lastName"
        }
    }

    override fun onResume() {
        super.onResume()
        binding.tvOutput.text = "Click Button Load Data"
    }
}
