package com.sunfusheng.algo

import com.sunfusheng.algo.Algo.StackQueue.MaxWindow
import java.io.File
import java.io.Serializable


data class AlgoItem(
    val category: Pair<String, String>,
    val className: String? = null,
    val subject: String? = null,
    val hardLevel: Int = 1
) : Serializable {
    fun getFilePath(): String {
        return "Algo/" + category.first + File.separator + className + ".java"
    }

    fun getHardLevel(): String {
        var level = hardLevel;
        if (hardLevel < 1) level = 1
        if (hardLevel > 4) level = 4
        val sb = StringBuilder("难度：")
        for (i in 1..4) {
            sb.append(if (i <= level) "★" else "☆")
        }
        return sb.toString()
    }
}


val StackQueue = "StackQueue" to "栈和队列"
val LinkedList = "LinkedList" to "链表"
val BinaryTree = "BinaryTree" to "二叉树"


fun getDataSource(): ArrayList<ArrayList<AlgoItem>> {
    val lists = ArrayList<ArrayList<AlgoItem>>()
    lists.add(getStackQueueDataSource())
    return lists
}


private fun getStackQueueDataSource(): ArrayList<AlgoItem> {
    val list = ArrayList<AlgoItem>()
    list.add(AlgoItem(StackQueue))
    list.add(
        AlgoItem(
            category = StackQueue,
            className = MaxWindow::class.simpleName,
            subject = "生成窗口最大值数组",
            hardLevel = 2
        )
    )
    return list
}
