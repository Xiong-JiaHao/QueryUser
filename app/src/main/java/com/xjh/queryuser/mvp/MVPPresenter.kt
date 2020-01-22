package com.xjh.queryuser.mvp

import com.xjh.queryuser.bean.Account
import com.xjh.queryuser.callback.MCallback

class MVPPresenter {

    private val mView: IMVPView
    private val mModel: MVPModel

    constructor(mView: IMVPView) {
        this.mView = mView
        mModel = MVPModel()
    }

    fun getData() {
        mModel.getAccountData(mView.getUserInput(), object : MCallback {
            override fun onSuccess(account: Account) {
                mView.showSuccessPage(account)
            }

            override fun onFailed() {
                mView.showFailedPage()
            }
        })
    }
}