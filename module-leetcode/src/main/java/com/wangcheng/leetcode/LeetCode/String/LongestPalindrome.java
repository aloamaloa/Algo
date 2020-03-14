package com.wangcheng.leetcode.LeetCode.String;

import com.sunfusheng.algo.common.util.LeetCodeUtil;

/**
 * 【题目】
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 你可以假设 s 的最大长度为 1000。
 * <p>
 * 【示例】
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author liwangcheng
 * @date 2020/3/14.
 */
public class LongestPalindrome {

    /**
     * 中心扩展算法
     * 思路：
     * 观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1 个这样的中心。
     *
     * 为什么会是 2n - 1 个，而不是 n 个中心？
     * 原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 “abba” 的中心在两个 ‘b’ 之间）。
     */
    public String solution(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        LongestPalindrome palindrome = new LongestPalindrome();
        LeetCodeUtil.log("babad 的最大回文子串是：" + palindrome.solution("babad"));
        LeetCodeUtil.log("abbda 的最大回文子串是：" + palindrome.solution("abbda"));
    }
}
