package br.com.kodigos.mysofie.Sofie.SofieList

import br.com.kodigos.mysofie.Model.SofieBody

interface SofieListContract {
    interface View{

        fun showMsg(text: String)
        fun load(loading: Boolean)
        fun showList(list: List<SofieBody>)


    }

    interface Presenter{

        fun carregarList()

    }
}