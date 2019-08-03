package com.wya.env

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Message
import android.view.KeyEvent
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.wya.env.base.BaseActivity
import com.wya.env.module.home.fragment.Fragment1
import com.wya.env.module.mine.Fragment2
import kotlinx.android.synthetic.main.main_activity.*

/**
 * @date: 2019/1/9 14:04
 * @author: Chunjiang Mao
 * @classname: MainActivity
 * @describe: MainActivity
 */

class MainActivity : BaseActivity() {


    private var fragmentManager: FragmentManager? = null
    private var fragmentTransaction: FragmentTransaction? = null
    private var fragment1: Fragment1? = null
    private var fragment2: Fragment2? = null

    override fun initView() {
        initFragment()
        setToolBar()
    }

    private fun initFragment() {
        fragment1 = Fragment1()
        fragment2 = Fragment2()
        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction!!.add(R.id.content, fragment1!!)
        fragmentTransaction!!.add(R.id.content, fragment2!!)
        fragmentTransaction!!.show(fragment1!!).hide(fragment2!!).commit()
    }

    private fun setToolBar() {
        //取消偏移
        tab.disableShiftMode()
        //取消item动画
        tab.enableAnimation(false)
        //item点击监听
        tab.setOnNavigationItemSelectedListener { item: MenuItem ->
            fragmentTransaction = fragmentManager!!.beginTransaction()
            when (item.itemId) {
                R.id.navigation_my -> fragmentTransaction!!.show(fragment2!!).hide(fragment1!!).commit()
                R.id.navigation_my_study -> fragmentTransaction!!.show(fragment1!!).hide(fragment2!!).commit()
                else -> {
                }
            }
            true
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.main_activity
    }

    /**
     * 双击返回键退出app
     */
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun exit() {
        if (!isExit) {
            isExit = true
            showShort("再按一次退出程序")
            handler.sendEmptyMessageDelayed(0, 2000)
        } else {
            this.finish()
        }
    }

    companion object {

        private var isExit = false

        @SuppressLint("HandlerLeak")
        private val handler = object : Handler() {

            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                isExit = false
            }
        }
    }

}
