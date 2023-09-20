package br.edu.scl.ifsp.ads.contatopdm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.scl.ifsp.ads.contatopdm.R
import br.edu.scl.ifsp.ads.contatopdm.databinding.ActivityContactBinding
import br.edu.scl.ifsp.ads.contatopdm.model.Constant.EXTRA_CONTACT
import br.edu.scl.ifsp.ads.contatopdm.model.Contact
import kotlin.random.Random

class ContactActivity : AppCompatActivity() {
    private val acb: ActivityContactBinding by lazy {
        ActivityContactBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(acb.root)
        with (acb) {

            saveBt.setOnClickListener {
                val contact: Contact = Contact(
                    id = generateId(),
                    name = nameEt.text.toString(),
                    address = addressEt.text.toString(),
                    phone = phoneEt.text.toString(),
                    email = emailEt.text.toString(),

                    )

                val resultIntent = Intent ()
                resultIntent.putExtra(EXTRA_CONTACT, contact)
                setResult(RESULT_OK, resultIntent)
                finish()

            }
        }
    }

    private fun generateId(): Int = Random(System.currentTimeMillis()).nextInt()
}