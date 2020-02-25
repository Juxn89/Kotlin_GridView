package com.example.gridview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*

class AdaptadorCustom(var context: Context, items:ArrayList<Fruta>): BaseAdapter() {
    var items:ArrayList<Fruta>? = null

    init {
        this.items = items
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = convertView
        var holder:ViewHolder? = null

        if(holder == null) {
            vista = LayoutInflater.from(context).inflate(R.layout.template_grid, null)
            holder = ViewHolder(vista)
            vista.tag = holder
        }
        else {
            holder = vista?.tag as? ViewHolder
        }

        val item = items?.get(position) as? Fruta
        holder?.nombre?.text = item?.nombre
        holder?.imagen?.setImageResource(item?.imagen!!)
        holder?.boton?.setOnClickListener {
            Toast.makeText(context, "El botón dice: ${item?.nombre}", Toast.LENGTH_LONG).show()
        }

        if ( (position + 1) % 2 == 0) {
            holder?.contendor?.setBackgroundColor(Color.GRAY)
        }

        return vista!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items?.count()!!
    }

    private class ViewHolder(view: View) {
        var nombre:TextView? = null
        var imagen:ImageView? = null
        var boton:Button? = null
        var contendor:LinearLayout? = null

        init {
            this.nombre = view.findViewById(R.id.nombre)
            this.imagen = view.findViewById(R.id.imagen)
            this.boton = view.findViewById(R.id.bBoton)
            this.contendor = view.findViewById(R.id.llContenedor)
        }
    }
}