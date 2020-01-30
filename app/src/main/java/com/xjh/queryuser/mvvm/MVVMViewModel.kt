package com.xjh.queryuser.mvvm

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View

import com.xjh.queryuser.bean.Account
import com.xjh.queryuser.callback.MCallback

import com.xjh.queryuser.BR

class MVVMViewModel : BaseObservable() {

    private val mvvmModel: MVVMModel = MVVMModel()
    @get:Bindable
    var userInput: String? = null
        set(userInput) {
            field = userInput
            notifyPropertyChanged(BR.userInput)
        }
    @get:Bindable
    var result: String? = null
        set(result) {
            field = result
            notifyPropertyChanged(BR.result)
        }

    fun getData(view: View) {
        this.userInput?.let {
            mvvmModel.getAccountData(it, object : MCallback {
                override fun onSuccess(account: Account) {
                    result = "用户账号：" + account.name + " | " + "用户等级：" + account.level
                }

                override fun onFailed() {
                    result = "获取数据失败"
                }
            })
        }
    }
}
