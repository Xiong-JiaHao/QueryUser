package com.xjh.queryuser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.xjh.queryuser.bean.Account
import com.xjh.queryuser.callback.MCallback
import kotlinx.android.synthetic.main.activity_normal.*
import java.util.*

class NormalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
        initEvent()
    }

    private fun initEvent() {
        submit.setOnClickListener {
            getAccountData(getUserInput(), object : MCallback {
                override fun onSuccess(account: Account) {
                    showSuccessPage(account)
                }

                override fun onFailed() {
                    showFailedPage()
                }
            })
        }
    }

    // 获取用户输入信息
    private fun getUserInput(): String {
        return userName.text.toString()
    }

    // 展示获取数据成功的界面
    private fun showSuccessPage(account: Account) {
        result.text = "用户账号：" + account.name + " | " + "用户等级：" + account.level
    }

    // 展示获取数据失败的界面
    private fun showFailedPage() {
        result.text = "获取数据失败"
    }

    // 模拟查询账号数据
    private fun getAccountData(accountName: String, callback: MCallback) {
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
