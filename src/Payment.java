import java.io.*;
import java.nio.charset.StandardCharsets;
 
public class Payment {
 
    /*
     * 编程挑战说明: A person has taken a loan of $6000.00 with a fixed annual interest
     * rate of 6% for 5 years with no down payment. The monthly payment has been
     * fixed at $116.00 for entire term of the loan. Here is the formula to
     * calculate monthly fixed payment: (NOTE: See attachment)
     * 
     * P = (monthly rate * Loan amount) / (1 - (1+monthly interest rate)^-n) Here n
     * is the number of payment periods. Write a program to: 1. To calculate monthly
     * payment 2. To print out monthly payment and total interest payment for the
     * duration of loan rounded to its nearest integer
     * 
     * 输入: 6000~5~6~0
     * 
     * 输出: $116.00~$960
     * 
     * Test 1 测试输入 下载测试输入25000~10~6~0 预期输出 下载测试输出$277.55~$8306 Test 2 测试输入
     * 下载测试输入30000~10~6~5000 预期输出 下载测试输出$277.55~$8306 Test 3 测试输入 下载测试输入5000~5~6~0
     * 预期输出 下载测试输出$96.66~$800
     */
    public static double monthlyPayment(double amt, double year, double rate, double payment)
 
    {
 
        amt -= payment;
 
        double P = (rate * amt / 1200) / (1 - Math.pow((1 + rate / 1200), -1 * year * 12));
 
        return P;
 
    }
 
    public static void helper(double rate, double year, double payment, double amt)
 
    {
        double mP = monthlyPayment(amt, year, rate, payment);
 
        System.out.print("$" + (double) Math.round(mP * 100) / 100 + "~");
 
        amt -= payment;
 
        System.out.println("$" + (int) (Math.rint(mP * year * 12 - amt)));
    }
 
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String[] strs = line.split("~");
            double rate = Double.parseDouble(strs[2]);
            double year = Double.parseDouble(strs[1]);
            double payment = Double.parseDouble(strs[3]);
            double amt = Double.parseDouble(strs[0]);
            helper(rate, year, payment, amt);
        }
    }
}