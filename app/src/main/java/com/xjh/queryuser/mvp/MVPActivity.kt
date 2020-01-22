package com.xjh.queryuser.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.xjh.queryuser.R
import com.xjh.queryuser.bean.Account
import kotlinx.android.synthetic.main.activity_normal.*

class MVPActivity : AppCompatActivity(), IMVPView {

    private lateinit var mMVPPresenter: MVPPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)
        mMVPPresenter = MVPPresenter(this)
        initEvent()
    }

    private fun initEvent() {
        submit.setOnClickListener {
            mMVPPresenter.getData()
        }
    }

    // 获取用户输入信息
    override fun getUserInput(): String {
        return userName.text.toString()
    }

    // 展示获取数据成功的界面
    override fun showSuccessPage(account: Account) {
        result.text = "用户账号：" + account.name + " | " + "用户等级：" + account.level
    }

    // 展示获取数据失败的界面
    override fun showFailedPage() {
        result.text = "获取数据失败"
    }
}
