package br.com.kodigos.mysofie.Sofie.SofieList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.kodigos.mysofie.Model.SofieBody
import br.com.kodigos.mysofie.R
import br.com.kodigos.mysofie.Sofie.SofieNewTask.SofieNewTaskActivity
import br.com.kodigos.mysofie.Utils.ShowMessage
import kotlinx.android.synthetic.main.activity_sofie_list.*

class SofieListActivity : AppCompatActivity(), SofieListContract.View {

    lateinit var presenter: SofieListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sofie_list)


        //click Floating Button
        //Add New Task
        floating_action_button.setOnClickListener {
            startActivity(Intent(this,  SofieNewTaskActivity::class.java))
        }

        presenter = SofieListPresenter(this)

        presenter.carregarList()
    }

    override fun showMsg(text: String) {
        ShowMessage.showMessage(this, "Atenção", text, "OK", "")
    }

    override fun load(loading: Boolean) {
        if(loading) {
            ShowMessage.loadMessage(this, "Atenção", "Carregando...")
        }else{
            ShowMessage.fecharLoadMessage()
        }
    }

    override fun showList(list: List<SofieBody>) {
        recyclerSofie.setHasFixedSize(true)
        val linear = LinearLayoutManager(this)
        linear.orientation = LinearLayoutManager.VERTICAL
        recyclerSofie.layoutManager = linear
        recyclerSofie.adapter = SofieListAdapter(list)
        recyclerSofie.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
    }
}