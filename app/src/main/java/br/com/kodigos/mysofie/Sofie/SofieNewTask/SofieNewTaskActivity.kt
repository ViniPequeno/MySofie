package br.com.kodigos.mysofie.Sofie.SofieNewTask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.com.kodigos.mysofie.Model.SofieBody
import br.com.kodigos.mysofie.R
import br.com.kodigos.mysofie.Sofie.SofieList.SofieListContract
import br.com.kodigos.mysofie.Utils.ShowMessage
import kotlinx.android.synthetic.main.activity_sofie_new_task.*

class SofieNewTaskActivity : AppCompatActivity(), SofieNewTaskContract.View {

    lateinit var presenter: SofieNewTaskContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sofie_new_task)

        supportActionBar!!.setHomeAsUpIndicator(R.drawable.remove)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        presenter = SofieNewTaskPresenter(this)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_sofienewtask, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                android.R.id.home -> {
                    ShowMessage.showMessage(this, "", "Cancelar essa tarefa?",
                        "Sim", "Não", {
                            back()
                        }, {

                        })
                }
                R.id.confirmarNewTask -> {
                    presenter.confirmarNewTask(
                        SofieBody(
                            title = tarefaTitle.text.toString(),
                            email = tarefaEmail.text.toString(),
                            description = tarefaDescricao.text.toString(),
                            _id = "",
                            whenDate = ""
                        )
                    )
                }

            }
        }
        return true
    }

    override fun showMsg(text: String, modo: Int) {
        ShowMessage.showMessage(this, "Atenção", text, "OK", "")
        if(modo == 1){
            back()
        }
    }

    override fun load(loading: Boolean) {
        if (loading) {
            ShowMessage.loadMessage(this, "Atenção", "Carregando...")
        } else {
            ShowMessage.fecharLoadMessage()
        }
    }

    override fun back() {
        finish()
    }
}