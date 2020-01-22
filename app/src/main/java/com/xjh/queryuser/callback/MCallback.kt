package com.xjh.queryuser.callback

import com.xjh.queryuser.bean.Account

interface MCallback {
    fun onSuccess(account: Account)
    fun onFailed()
}