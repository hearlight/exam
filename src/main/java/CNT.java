import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CNT {
    /**
     * 主函数，用于从标准输入读取一行文本，统计并输出二元组和三元组及其出现的次数。
     *
     * @param args 命令行参数，本程序不使用
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            String[] inputArray = input.split(" ");
            input = inputArray[1];
            Map<String, Integer> result = new HashMap<>();
            for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                String pair = input.substring(i, j + 1);
                if (pair.length() <= 3) {
                    result.put(pair, result.getOrDefault(pair, 0) + 1);
                }
            }
        }

            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());

            }}catch (Exception e) {
            System.out.println("Need a string");
        }

    }
}