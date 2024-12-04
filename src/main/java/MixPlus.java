import java.util.Scanner;
import java.util.regex.Pattern;

public class MixPlus {
    private static final Pattern HEX_PATTERN = Pattern.compile("0[xX][0-9a-fA-F]+");

    public static void main(String[] args) {
        String sixteen = "0x";
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input == null) {
            System.out.println("ERROR");
            return;
        }
        String[] inputs = input.split(" ");  //分离出./mixplus
        if(inputs.length != 3) {  //两数和，多个或少于都会错误
            System.out.println("ERROR");
            return;
        }
        try{Integer num1 = convertToDecimal(inputs[1]);
            Integer num2 = convertToDecimal(inputs[2]);
            String hexString = Integer.toHexString(num1 + num2);
            hexString = sixteen +hexString;  //加上"0x"的前缀
            System.out.println(hexString);
            System.out.println(num1 + num2);
        }catch (Exception e) {
            System.out.println("ERROR");  //匹配失败
        }
    }

    /**
     * 判断输入的字符串是否为合法的十六进制或十进制数，并将其转换为十进制数返回。
     *
     * @param input 输入的字符串，可能是十六进制或十进制数
     * @return 输入字符串对应的十进制数
     * @throws NumberFormatException 如果输入的字符串既不是合法的十六进制数也不是合法的十进制数
     */
    //判断十六进制和十进制的合法性并返回十进制数
    private static int convertToDecimal(String input) {
        // 匹配十六进制数
        if (Pattern.matches("0[xX][0-9a-fA-F]+", input)) {
            return Integer.parseInt(input.substring(2), 16);
        }
        // 匹配十进制数（默认情况）
        return Integer.parseInt(input);
    }
}