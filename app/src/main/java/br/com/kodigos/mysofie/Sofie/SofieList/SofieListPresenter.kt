package br.com.kodigos.mysofie.Sofie.SofieList

import br.com.kodigos.mysofie.WebClient.WebClients.SofieWebClient

class SofieListPresenter(var view: SofieListContract.View) :
    SofieListContract.Presenter {


    override fun carregarList() {
        view.load(true)
        SofieWebClient().getTask({ it ->
            view.showList(it.data.sortedByDescending {
                it.whenDate
            })
            view.load(false)
        }, {
            view.load(false)
            view.showMsg("Erro ao carregar a lista!")
        })
    }


}