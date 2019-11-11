package java.practice.algorithm;

/**
 * 字符串的反转及替换
 * 本例使用递归实现字符串反转
 */
public class ReverseString {
    public static void main(String args[]) {
        System.out.println(reverse("abcd"));
    }

    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1) {
            return originStr;
        }
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
