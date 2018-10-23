import java.util.Random;

public class Case3 {

    /**
     * Не понял точно как решить
     * @param args
     */
    public static void main(String[] args) {
        Random rnd = new Random();
        Integer num = rnd.nextInt();

        // Вариант 1
        // Тут используется цикл
        String str = String.valueOf(num);
        // Тут используется цикл
        int idx = str.lastIndexOf('0');

        if (idx!=-1) {
            char[] chArr = str.toCharArray();
            chArr[idx]='1';
            str = new String(chArr);
            System.out.println(str);
        } else {
            System.out.println("There is no 0 in number");
        }

    }

}
