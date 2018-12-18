package LeetCode.Facebook;

public class IntegertoEnglishWords273 {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String[] lessThan20Words = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tyWords = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] dexWords = {"Billion", "Million", "Thousand", "Hundred"};
        int[] radix = {1000000000, 1000000, 1000, 100};
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < radix.length; ++i) {
            count = num / radix[i];
            if (count == 0) {
                continue;
            }
            sb.append(numberToWords(count) + " ");
            sb.append(dexWords[i] + " ");
            num %= radix[i];
        }
        if (num < 20) {
            sb.append(lessThan20Words[num]);
        } else {
            sb.append(tyWords[num / 10 - 2] + " ");
            sb.append(lessThan20Words[num % 10]);
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        System.out.println(new IntegertoEnglishWords273().numberToWords(100));
    }
}
