import java.util.regex.Pattern;

public class IpMatch {
    /**
     * Ip地址判断<br>
     * 符号 '\d'等价的正则表达式'[0-9]',匹配数字0-9<br>
     * {1,3}表示匹配三位以内的数字（包括三位数）
     *
     * @param str
     * @return
     */
    public static boolean isIP(String str) {

        // 匹配 1
        // String regex = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
        // 匹配 2
        String regex = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";

        // 匹配1 和匹配2均可实现Ip判断的效果
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(str).matches();

    }

}
