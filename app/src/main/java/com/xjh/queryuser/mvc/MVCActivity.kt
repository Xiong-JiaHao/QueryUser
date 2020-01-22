package com.xjh.queryuser.mvc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.xjh.queryuser.R
import com.xjh.queryuser.bean.Account
import com.xjh.queryuser.callback.MCallback
import kotlinx.android.synthetic.main.activity_normal.*

class MVCActivity : AppCompatActivity() {

    private lateinit var mMVCModel: MVCModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
        mMVCModel = MVCModel()
        initEvent()
    }

    private fun initEvent() {
        submit.setOnClickListener {
            mMVCModel.getAccountData(getUserInput(), object : MCallback {
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
}
