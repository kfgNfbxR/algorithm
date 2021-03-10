package org.example;

/**
 * @author mouxh 2021/3/8 16:57
 */
public class ReplaceBlank {

    public static void main(String[] args) {
        String str = "hello world";
        System.out.println(replaceBlank(str));
    }


    private static String replaceBlank(String str) {

        char[] chars = str.toCharArray();
        int blankNums = 0;
        for (char aChar : chars) {
            if (' ' == aChar) {
                blankNums++;
            }
        }

        char[] newChars = new char[chars.length + (blankNums * 2)];

        for (int k = 0, j = 0; k < chars.length; k++) {
            if (chars[k] == ' ') {
                newChars[j++] = '%';
                newChars[j++] = '2';
                newChars[j++] = '0';
            } else {
                newChars[j++] = chars[k];
            }
        }

        return new String(newChars);
    }

}
