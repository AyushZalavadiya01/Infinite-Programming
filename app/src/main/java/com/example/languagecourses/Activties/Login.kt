package com.example.languagecourses.Activties

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.TextView
//import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
//import com.example.languagecourses.Activties.information
import com.example.languagecourses.R
import com.example.languagecourses.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

@Suppress("DEPRECATION")
class Login : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth=FirebaseAuth.getInstance()
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=FirebaseAuth.getInstance()


        binding.registerLayout1.setOnClickListener {
            val intent = Intent(this, Registration ::class.java)
            startActivity(intent)
            finish()

        }


        //initialize animation

        val fade_in = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val bottom_down = AnimationUtils.loadAnimation(this, R.anim.bottom_down)

        //setting the bottom down animation on top layout

        binding.topLinearLayout.animation =bottom_down

        //create handler for other layout

        var handler = Handler()
        var runnable = Runnable{

            //let's set fade in animation  on other layout

            binding.cardView3.animation = fade_in
//            binding.cardView4.animation = fade_in
            binding.textView.animation = fade_in
            binding.textView3.animation = fade_in
            binding.registerLayout1.animation = fade_in

        }


        handler.postDelayed(runnable,100)






        binding.btnlogin.setOnClickListener {
            if(check()){
                val email=binding.Email.text.toString()
                val password=binding.Pass.text.toString()
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                        task->
                    if(task.isSuccessful){

                        //Toast.makeText(this,"Succesfull",Toast.LENGTH_LONG).show()
                        val intent = Intent(this,MainActivity2 ::class.java)
                        intent.putExtra("email",email )
                        startActivity(intent)
                        finish()

                    }
                    else{
                        Toast.makeText(this,"Failed", Toast.LENGTH_LONG).show()
                    }

                }
            }
            else{
//                val intent = Intent(this,MainActivity2 ::class.java)
//                startActivity(intent)

              Toast.makeText(this,"Enter Details", Toast.LENGTH_SHORT).show()
            }
        }
        binding.forgot.setOnClickListener {
            val builder=AlertDialog.Builder(this)
            val view=layoutInflater.inflate(R.layout.dialog_forgot,null)
            val userEmail=view.findViewById<EditText>(R.id.Edit)

            builder.setView(view)
            val dialog=builder.create()

            view.findViewById<TextView>(R.id.btnReset).setOnClickListener {
                Compare(userEmail)
                dialog.dismiss()
            }
            view.findViewById<TextView>(R.id.btnCancel).setOnClickListener {
                dialog.dismiss()
            }
            if(dialog.window!=null){
                dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
            }
            dialog.show()
        }


    }
    private fun check():Boolean{
        if(binding.Email.text.toString().trim{it<=' '}.isNotEmpty()&& binding.Pass.text.toString().trim{it<=' '}.isNotEmpty()){
            return true
        }
        return false
    }
    private fun Compare(email: EditText){
        if(binding.Email.text.toString().isEmpty()){
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
            return
        }
        auth.sendPasswordResetEmail(email.text.toString()).addOnCompleteListener { task->
            if(task.isSuccessful){
                Toast.makeText(this,"Check Your Email",Toast.LENGTH_SHORT).show()
            }
        }

    }

   


}
