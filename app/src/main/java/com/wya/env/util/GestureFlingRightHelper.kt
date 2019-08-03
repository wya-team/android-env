package com.wya.env.util

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent

import com.wya.env.App
import com.wya.utils.utils.ScreenUtil

/**
 * @author: Caiqi Zen
 * @classname: GestureFlingRightHelper
 * @describe:
 */

class GestureFlingRightHelper : GestureDetector.OnGestureListener {
    private var minDistance = 180
    private var mGestureCallBack: GestureRightCallBack? = null

    fun getGestureDetector(context: Context, callBack: GestureRightCallBack, widthPixels: Int): GestureDetector {
        minDistance = widthPixels / 3
        mGestureCallBack = callBack
        if (mGestureCallBack == null) {
            mGestureCallBack = object : GestureRightCallBack {
                override fun handleFlingRightAction(): Boolean {
                    return false
                }
            }
        }

        return GestureDetector(context, this)
    }

    override fun onDown(e: MotionEvent): Boolean {
        return false
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        var result = false
        if (e1 != null && e2 != null) {
            val xFling = e2.x - e1.x
            val yFling = e2.y - e1.y
            if (e1.x < (ScreenUtil.getScreenWidth(App.instance!!) / 5).toFloat() && xFling > minDistance.toFloat() && Math.abs(yFling) < xFling / 2.0f) {
                result = mGestureCallBack!!.handleFlingRightAction()
            }
        }

        return result
    }

    override fun onLongPress(e: MotionEvent) {}

    override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        return false
    }

    override fun onShowPress(e: MotionEvent) {}

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        return false
    }

    interface GestureRightCallBack {
        /**
         * handleFlingRightAction
         *
         * @return
         */
        fun handleFlingRightAction(): Boolean
    }

    companion object {
        private var instances: GestureFlingRightHelper? = null

            get() {
                if (field == null) {
                    field = GestureFlingRightHelper()
                }

                return field
            }
        @Synchronized
        fun get():GestureFlingRightHelper{
            return instances!!
        }
    }
}
