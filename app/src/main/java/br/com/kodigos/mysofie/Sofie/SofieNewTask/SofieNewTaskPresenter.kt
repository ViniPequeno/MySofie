package br.com.kodigos.mysofie.Sofie.SofieNewTask

import br.com.kodigos.mysofie.Model.SofieBody
import br.com.kodigos.mysofie.Sofie.SofieList.SofieListContract
import br.com.kodigos.mysofie.WebClient.WebClients.SofieWebClient

class SofieNewTaskPresenter(var view: SofieNewTaskContract.View) : SofieNewTaskContract.Presenter {


    override fun confirmarNewTask(task: SofieBody) {


        if (task.email.isBlank()) {
            view.showMsg("Email é obrigatório")
        } else if (!task.email.contains("@")) {
            view.showMsg("Email inválido!")
        } else if (task.title.isBlank()) {
            view.showMsg("Título é obrigatório")
        } else {
            view.load(true)
            SofieWebClient().postTask(task, {
                view.load(false)
                if (it.success) {
                    view.showMsg("Salvo com sucesso!",1)
                } else {
                    view.showMsg("Erro ao salvar!")
                }
            }, {
                view.load(false)
                view.showMsg("Erro ao salvar!")
            })
        }
    }
}