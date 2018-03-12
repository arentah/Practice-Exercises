import java.math.BigDecimal;

public class TestEnvironment {
    public static void main(String[] args){

        BigDecimal bigDecimal = new BigDecimal("20.889");

        //System.out.println(Math.ceil(32.1885));

        double t = Math.ceil(bigDecimal.doubleValue() * 20) / 20;

        //System.out.println(t);

        bigDecimal = bigDecimal.multiply(new BigDecimal("20")).setScale(0, BigDecimal.ROUND_UP).divide(new BigDecimal("20"))
            .setScale(2, BigDecimal.ROUND_HALF_UP);
        //bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);


        //String tt = ""+t;
        //bigDecimal = new BigDecimal(tt).setScale(2, BigDecimal.ROUND_HALF_UP);


        //System.out.println(bigDecimal);

        Item[] it = new Item[3];

        it[0] = new Item(1,"book",new BigDecimal("12.49"),false,"book");
        it[1] = new Item(1,"CD",new BigDecimal("14.99"),false,"music");
        it[2] = new Item(1,"chocolate bar",new BigDecimal(".85"),false,"food");

        CalculateTax cal = new CalculateTax(it);
        System.out.println(cal.calculateTotalSale());

    }
}
