package br.com.kodigos.mysofie.Utils

import android.app.AlertDialog
import android.content.Context

class ShowMessage {
    companion object{

        var dialogLoad: AlertDialog? =null

        fun showMessage(context: Context, title: String, message: String,
                        button1: String, button2: String = "",
                        funcao1: () -> (Unit) = {}, funcao2: () -> (Unit) = {}){
            val builder = AlertDialog.Builder(context)

            builder.setTitle(title)

            builder.setMessage(message)

            builder.setPositiveButton(button1){ dialog, _ ->
                funcao1()
                dialog.cancel()
            }
            if(button2.isNotBlank()){
                builder.setNegativeButton(button2){ dialog, _ ->
                    funcao2()
                    dialog.cancel()
                }
            }

            val dialog: AlertDialog = builder.create()
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()
        }

        fun loadMessage(context: Context, title: String, message: String){
            val builder = AlertDialog.Builder(context)

            builder.setTitle(title)

            builder.setMessage(message)


            dialogLoad = builder.create()
            dialogLoad!!.setCanceledOnTouchOutside(false)
            dialogLoad!!.show()
        }

        fun fecharLoadMessage(){
            dialogLoad!!.dismiss()
        }
    }
}