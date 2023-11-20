package blog.howardli.java_external_study.algorithm;

import java.util.Arrays;

public class KMPMain {
    /*
    given a string str and a pattern pat, find the first occurrence of pat in str(use KMP algorithm)
     */
    public static void main(String[] args) {
        String str = "ababababca";
        String pat = "abababca";
        System.out.println(kmp(str, pat));
    }

    /*
    return the index of the first occurrence of pat in str, if not found, return -1
     */
    public static int kmp(String str, String pat) {
        int[] next = getNext(pat);
        int i = 0, j = 0;
        while (i < str.length() && j < pat.length()) {
            if (j == -1 || str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == pat.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    /*
    prefix table
    1. 初始化：i = 0, j = -1
    2. 比較：如果j == -1或者當前字符匹配成功（即str[i] == str[j]），都令i++, j++，即next[i+1] = j+1
    3. 如果j != -1且當前字符匹配失败（即str[i] != str[j]），则令j = next[j]，此时相当于模式串向右移动j - next[j]位
    4. 重复2，3步骤，直到i到達末尾或者j到達末尾
    a : -1
    ab : 0
    aba : 0
    abab : 1
    ababa : 2
    ababab : 3
    abababc : 4
    abababca : 0 (不滿足prefix table 規則)
    example:
    i: 0, j: -1 初始化
    i: 1, j: 0 j 和 i 都加 1, j 覆值給 next[i]
    pat.charAt(i): b pat.charAt(j): a
    i: 1, j: -1 next[j] 覆值給 j
    i: 2, j: 0 j 和 i 都加 1, j 覆值給 next[i]
    pat.charAt(i): a pat.charAt(j): a
    i: 3, j: 1 j 和 i 都加 1, j 覆值給 next[i]
    pat.charAt(i): b pat.charAt(j): b
    i: 4, j: 2 j 和 i 都加 1, j 覆值給 next[i]
    pat.charAt(i): a pat.charAt(j): a
    i: 5, j: 3 j 和 i 都加 1, j 覆值給 next[i]
    pat.charAt(i): b pat.charAt(j): b
    i: 6, j: 4 j 和 i 都加 1, j 覆值給 next[i]
    pat.charAt(i): c pat.charAt(j): a
    i: 6, j: 2 j 不滿足條件,next[j] 覆值給 j
    pat.charAt(i): c pat.charAt(j): a
    i: 6, j: 0 j 不滿足條件,next[j] 覆值給 j
    pat.charAt(i): c pat.charAt(j): a
    i: 6, j: -1 j 不滿足條件,next[j] 覆值給 j
    ans: [-1, 0, 0, 1, 2, 3, 4]
     */
    private static int[] getNext(String pat) {
        int[] next = new int[pat.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < pat.length() - 1) {
            if (j == -1 || pat.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }
}