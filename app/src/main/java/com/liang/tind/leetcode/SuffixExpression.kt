package com.liang.tind.leetcode

import java.util.*

/**
 *@author: lonnie.liang
 *date: 2022/05/02 21:53
 *
 */
class SuffixExpression {

    /**
     * 将中缀表达式转为后缀表达式
     * 例如："1 + ((2 + 3) * 4) - 5" 转为"123+4*+5-"
     */
    fun test(expression: String) {
        val notBlankString = expression.replace(" ", "")

        /**
         * 思路：1.遇到操作数就放入list
         * 2.遇到操作符
         *  2.1 s1栈顶元素是"(" 直接入栈
         *  2.2 如果当前操作符运算优先级比s1栈顶元素高就入栈，否则将s1栈顶元素出栈且入list然后重复2的判断
         * 3.遇到括号
         *  3.1如果是左括号直接入s1
         *  3.2右括号直接依次弹出s1栈顶元素并且入list直到遇到左括号，这时消掉这对括号。
         * 4.扫描结束后将s1的元素依次弹出入list
         * 5.list结果即后缀表达式
         */
        // 存储操作符的栈
        val s1 = Stack<String>()
        // 存储操作数的list
        val list = mutableListOf<String>()

        notBlankString.map { it.toString() }.forEach {
            //如果是一个数字
            when {
                it.matches(Regex("\\d+")) -> {
                    list.add(it)
                }
                it == "(" -> {
                    s1.push(it)
                }
                it == ")" -> {
                    // 依次弹出栈顶元素直到遇到左括号
                    while (s1.peek() != "(") {
                        list.add(s1.pop())
                    }
                    s1.pop() // 弹出"("消掉
                }
                else -> {
                    // 如果当前操作符运算优先级比s1栈顶元素高就入栈，否则将s1栈顶元素出栈且入list然后重复2的判断
                    while (s1.isNotEmpty()
                        && s1.peek() != "("
                        && s1.peek().toOperator().priority >= it.toOperator().priority
                    ) {
                        list.add(s1.pop())
                    }
                    s1.push(it)
                }
            }
        }

        while (s1.isNotEmpty()) {
            list.add(s1.pop())
        }

        println(list.joinToString(separator = ""))
    }

    enum class Operator(val operator: String, val priority: Int) {
        ADD("+", 1),
        MINUS("-", 1),
        MUL("*", 2),
        DIV("/", 2);
    }


    private fun String.toOperator(): Operator {
        return when (this) {
            Operator.ADD.operator -> Operator.ADD
            Operator.MINUS.operator -> Operator.MINUS
            Operator.MUL.operator -> Operator.MUL
            Operator.DIV.operator -> Operator.DIV
            else -> {
                throw IllegalArgumentException("unsupported operator:$this")
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SuffixExpression().test("1 + ((2 + 3) * 4) - 5")
        }
    }
}