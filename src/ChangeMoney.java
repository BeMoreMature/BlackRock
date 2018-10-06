import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
 
public class ChangeMoney {
    /*编程挑战说明:
        The goal of this challenge is to design a cash register program. You will be given two decimal numbers. The first is the purchase price (PP) of the item. The second is the cash (CH) given by the customer. Your register currently has the following bills/coins within it: 
        'PENNY': .01,
        'NICKEL': .05,
        'DIME': .10,
        'QUARTER': .25,
        'HALF DOLLAR': .50,
        'ONE': 1.00,
        'TWO': 2.00,
        'FIVE': 5.00,
        'TEN': 10.00,
        'TWENTY': 20.00,
        'FIFTY': 50.00,
        'ONE HUNDRED': 100.00
        The aim of the program is to calculate the change that has to be returned to the customer.
        输入:
        Your program should read lines of text from standard input. Each line contains two numbers which are separated by a semicolon. The first is the Purchase price (PP) and the second is the cash(CH) given by the customer.
        输出:
        For each line of input print a single line to standard output which is the change to be returned to the customer. In case the CH < PP, print out ERROR. If CH == PP, print out ZERO. For all other cases print the amount that needs to be returned, in terms of the currency values provided. The output should be alphabetically sorted.
        Test 1
        测试输入 下载测试输入15.94;16.00
        预期输出 下载测试输出NICKEL,PENNY
        Test 2
        测试输入 下载测试输入17;16
        预期输出 下载测试输出ERROR
        Test 3
        测试输入 下载测试输入35;35
        预期输出 下载测试输出ZERO
        Test 4
        测试输入 下载测试输入45;50
        预期输出 下载测试输出FIVE
        */
     
    public static void main(String[] args) throws IOException {
         
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String[] strs = line.split(";");
            double price = Double.parseDouble(strs[0]);
            double pay = Double.parseDouble(strs[1]);
            if(price > pay) {
                System.out.println("ERROR");
            }else if(price == pay) {
                System.out.println("ZERO");
            }else {
                String res = helper(pay - price);
                if(res.charAt(res.length() - 1) == ',') {
                    res = res.substring(0, res.length() - 1);
                }
                System.out.println(res);
            }
        }
    }
     
    public static String helper(double diff) {
        if(diff == 0) {
            return "";
        }
        if(diff < 0.05) {
            int n = (int) (diff / 0.01);
            return (n == 1 ? "" : n + " ") + "PENNY";
        }else if(diff < 0.1) {
            return "NICKEL," + helper(diff - 0.05);
        }else if(diff < 0.25) {
            int n = (int) (diff / 0.1);
            return (n == 1 ? "" : n + " ") + "DIME," + helper(diff - 0.1 * n);
        }else if(diff < 0.5) {
            return "QUARTER," + helper(diff - 0.25);
        }else if(diff < 1.00) {
            return "HALF DOLLAR," + helper(diff - 0.5);
        }else if(diff < 2.00) {
            return "ONE," + helper(diff - 1.00);
        }else if(diff < 5.00) {
            int n = (int) (diff / 2.00);
            return (n == 1 ? "" : n + " ") + "TWO," + helper(diff - 2.00 * n);
        }else if(diff < 10.00) {
            return "FIVE," + helper(diff - 5.00);
        }else if(diff < 20.00) {
            return "TEN," + helper(diff - 10.00);
        }else if(diff < 50.00) {
            int n = (int) (diff / 20.00);
            return (n == 1 ? "" : n + " ") + "TWENTY," + helper(diff - 20.00 * n);
        }else if(diff < 100.00) {
            return "FIFTY," + helper(diff - 50.00);
        }
        int n = (int) (diff / 100.00);
        return (n == 1 ? "" : n + " ") + "ONE HUNDRED" + helper(diff - 100.00 * n);
    }
}