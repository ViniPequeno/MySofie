package br.com.kodigos.mysofie.Sofie.SofieNewTask

import br.com.kodigos.mysofie.Model.SofieBody

interface SofieNewTaskContract {
    interface View{

        fun showMsg(text: String, modo: Int = 0)
        fun load(loading: Boolean)

        fun back()
    }

    interface Presenter{
        fun confirmarNewTask(task: SofieBody)
    }
}