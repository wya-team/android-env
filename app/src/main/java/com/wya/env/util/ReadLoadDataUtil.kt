package com.wya.env.util

import com.wya.env.uiview.App
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.Reader

/**
 *     @author : xdl
 *     @time   : 2019/08/08
 *     @describe :
 */

object ReadLoadDataUtil {

    /**
     * 读取asset文件夹中文件
     * @param fileName String 文件名称
     */
    @Throws(IOException::class)
    fun readAssetFile(fileName: String):String {

        val stringBuilder = StringBuilder()
        try {
            val assetManager = App.getInstance().assets
            val bf = BufferedReader(InputStreamReader(
                    assetManager.open(fileName)) as Reader?)
            var line: String?
            while (true) {
                line = bf.readLine()
                if (line == null) {
                    return stringBuilder.toString()
                }
                stringBuilder.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return stringBuilder.toString()
    }
}