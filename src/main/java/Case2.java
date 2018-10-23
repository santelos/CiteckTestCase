import java.util.Arrays;

/**
 * Вторая задача
 */
public class Case2 {

    /**
     * Рекурсивно смотрим на все возможно правильные подмножества<br></br>
     * Добавлены проверки на четность длинны строки,<br></br>
     * на количество всех скобок - оно должно быть одинаковым для отрывающихся и закрывающихся всех типов.<br></br>
     * По идее, это должно уменьшить best case сложность алгоритма
     */
    public static void main(String[] args) {
        String str= "([][(()[])])[]";
        System.out.println(checkRegular(str));
    }

    private static boolean checkRegular(String inStr){
        char[] chArr = inStr.toCharArray();

        // Если строка пустая, то поверок не требуется, потому что пусто - правильно
        // Предпроверка 1
        if (inStr.isEmpty()) return true;

        // Если длина массива не четная, то это не верно
        // Предпроверка 2
        if (chArr.length%2!=0) return false;

        // Количество встреченых скобок
        // 0 - [
        // 1 - ]
        // 2 - (
        // 3 - )
        int[] brArr = new int[4];

        // Подсчет всех открытых и закрытых скобок
        // Предпроверка 3
        for (char ch : chArr){
            switch (ch){
                case '[' : {brArr[0]++;break;}
                case ']' : {brArr[1]++;break;}
                case '(' : {brArr[2]++;break;}
                case ')' : {brArr[3]++;break;}
                default: continue;
            }
        }

        // Если количество открытых/закрытых скобок не одинаковое, то это плохо
        if (brArr[0]!=brArr[1] || brArr[2]!=brArr[3]) return false;


        // Если все предпроверки пройдены
        // Переинициализация массива
        brArr[0]=0;
        brArr[1]=0;
        brArr[2]=0;
        brArr[3]=0;

        boolean result = false;

        int pointer = 0;
        for (int i=0;i<chArr.length;i++){

            // Добавляем счетчик для каждого типа символа
            switch (chArr[i]){
                case '[' : {brArr[0]++;break;}
                case ']' : {brArr[1]++;break;}
                case '(' : {brArr[2]++;break;}
                case ')' : {brArr[3]++;break;}
                default: continue;
            }

            // Когда количество открывающихся/закрывающихся скобок каждого типа равное количество
            if (brArr[0]==brArr[1] && brArr[2]==brArr[3]) {

                // Рекурсивно смотрим на перове возможно правильное подмножество символов
                result = checkRegular(String.valueOf(Arrays.copyOfRange(chArr,pointer + 1,i)));

                // Обновляем указатель на начало нового пердположительно правильного множества
                pointer = i+1;
            }
        }

        // Если указатель стоит на конце множества, то это значит, что были вычеслены все подмножества входной строки
        // Если это не так, то значит были обработаны не все подмножества, а значит где-то произошла ошибка и нужно вернуть false
        return (pointer == chArr.length) && result;
    }

}
