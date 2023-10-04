package com.qt.aplicaciondispositivosmoviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import com.qt.aplicaciondispositivosmoviles.adapters.PersonaAdapter
import com.qt.aplicaciondispositivosmoviles.databinding.ActivityMainBinding
import com.qt.aplicaciondispositivosmoviles.model.Person

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding : ActivityMainBinding
    lateinit var listaPersonas : ArrayList<Person>
    lateinit var adapter : PersonaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listaPersonas = ArrayList()
        adapter = PersonaAdapter(this,listaPersonas)
        binding.btnAcept.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnAcept){
            var persona :Person= Person(binding.txtName.text.toString(), binding.txtEdadPerson.text.toString().toInt(),binding.txtUrlImage.text.toString())
            listaPersonas.add(persona)
            binding.txtName.text.clear()
            binding.txtEdadPerson.text.clear()
            binding.txtUrlImage.text.clear()
            binding.lstListPersonas.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }


}