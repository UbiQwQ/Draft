package basics.base;


/**
 * @Auther: carver
 * @Date: 2019/4/11 13:22
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: 从字符串中删除给定的字符。
 */
public class DeleteChar {

    public static void main(String[] args) {

        DeleteChar deleteChar = new DeleteChar();

        System.out.println(deleteChar.deleteChar("abccd", 'c'));
    }

    public String deleteChar(String str,char c) {

        String result = str.replace(c+"","");
        return result;
    }
}
