public class rare_item {
    public static void main(String[] args) {
        int result =  cal_rare_item();
        System.out.println("You won a rare item on the " + result + " try! It costed $" + cost(result) + "AUD in keys");
    }

    /* Calculate odds of winning */
    public static int cal_rare_item() {
        int cnt = 0;
        int item = 0;
        double raw_draw_value = 0;

        while (item == 0) {
            raw_draw_value = Math.random();

            if (raw_draw_value > 0.9974 && raw_draw_value <=1) {
                item = 1;
            }
            else {
                cnt++;
            }
        }
        return cnt;
    }

    public static double cost(int cnt) {
        return cnt * 3.5;
    }
}
