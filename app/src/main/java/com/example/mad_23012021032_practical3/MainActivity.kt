package com.example.mad_23012021032_practical3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val openurl=findViewById<Button>(R.id.urlbtn)
        val urllink =findViewById<EditText>(R.id.editTextText)

        var urldata=urllink.text.toString()
        openurl.setOnClickListener{
            val intent = Intent (Intent.ACTION_VIEW, Uri.parse(urldata))
            startActivity(intent)
        }


        val makeacall=findViewById<Button>(R.id.call)
        val phone=findViewById<EditText>(R.id.Phoneno)


        makeacall.setOnClickListener {
            val phoneno=phone.text.toString()
            val intent= Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneno"))
            startActivity(intent)
        }


        val contact=findViewById<Button>(R.id.calllogbtn)

        contact.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW)
            intent.data = CallLog.Calls.CONTENT_URI
            startActivity(intent)

        }


        val opencamara=findViewById<Button>(R.id.camarabtn)
        opencamara.setOnClickListener {
            val intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }


        val opengallary=findViewById<Button>(R.id.gallarybtn)
        opengallary.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW)
            intent.type="image/*"
            startActivity(intent)
        }

        val openloginpage=findViewById<Button>(R.id.loginbtn)
        openloginpage.setOnClickListener {
            val intent= Intent(this,loginpage::class.java)
            startActivity(intent)
        }
    }
}