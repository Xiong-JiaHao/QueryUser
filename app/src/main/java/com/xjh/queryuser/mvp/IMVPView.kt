package com.xjh.queryuser.mvp

import com.xjh.queryuser.bean.Account

interface IMVPView {
    fun getUserInput(): String
    fun showSuccessPage(account: Account)
    fun showFailedPage()
}