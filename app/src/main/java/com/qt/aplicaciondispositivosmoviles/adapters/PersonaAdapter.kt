package com.qt.aplicaciondispositivosmoviles.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.qt.aplicaciondispositivosmoviles.databinding.PersonCellBinding
import com.qt.aplicaciondispositivosmoviles.model.Person

class PersonaAdapter(val c: Context, val datos: ArrayList<Person> ) : BaseAdapter() {

    var context :Context
    var data : ArrayList<Person>

    init {
        context = c
        data = datos
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any {
        return data.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder : ViewHolder

        if (convertView == null){
            var itemBinding = PersonCellBinding.inflate(LayoutInflater.from(parent?.context),parent,false)
            holder = ViewHolder(itemBinding)
            holder.view = itemBinding.root
             holder.view.tag = holder

        }
        else {
                holder = convertView.tag as ViewHolder
        }
        val person = data.get(position)
        holder.binding.txtNombre.text = person.nombre
        holder.binding.txtEdad.text = person.edad.toString()
        holder.binding.imgAvatar.load(person.url){
            transformations(CircleCropTransformation())
        }
        return holder.view

    }

    class ViewHolder(itemBinding: PersonCellBinding)  {
        var view :View
        var binding : PersonCellBinding

        init {
            view = itemBinding.root
            binding = itemBinding
        }

    }

}