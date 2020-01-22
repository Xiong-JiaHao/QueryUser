package com.xjh.queryuser.mvp

import com.xjh.queryuser.bean.Account
import com.xjh.queryuser.callback.MCallback
import java.util.*

class MVPModel {

    // 模拟查询账号数据
    fun getAccountData(accountName: String, callback: MCallback) {
        val random = Random()
        val isSuccess = random.nextBoolean()
        if (isSuccess) {
            val account = Account(accountName, 100)
            callback.onSuccess(account)
        } else {
            callback.onFailed()
        }
    }
}