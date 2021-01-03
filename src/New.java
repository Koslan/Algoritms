import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class New {
    /*

    1) String beautify(String, String)



Метод возвращает заданную строку, обработанную в зависимости от заданного режима:

UPPERCASE
LOWERCASE
СAPITALIZE - Все Слова С Большой Буквы


2) int[][] charEntries(String)

Метод подсчитывает количество вхождений каждого символа в заданной строке и возвращает статистику как массив, где в первой строке каждого столбца лежит код встреченного символа, во второй строке - количество вхождений.



3)int countWords(String)

Метод подсчитывает количество слов в заданной строке.



4) int[][] wordLengths(String)

Метод подсчитывает количество слов каждой длины, встреченной в заданной строке. Результат хранит в первой строке длину слова, во второй - встреченное количество.



5) boolean validateCode(String)

Метод принимает строку вида "AX6BYU56UX6CV6BNT7NM 287430" и проверяет ее на соответствие таким правилам:

20 цифробуквенных символов перед пробелом, буквы верхнего регистра, цифр точно 6
6 цифровых символов в правой части строки, после пробела
все цифровые символы в левой части строки, будучи собранными последовательно, сгруппированными попарно и перемноженными друг на друга, дают произведение, равное правой части строки. (См. приложение)



для задач 1 - 4 словом считается беспробельная последовательность символов с цифробуквами, знаком подчеркивания (_), дефисом (-) и апострофом (`)
(Актуально для 1-4) На всякий случай напоминаю, что строка вполне может случиться пустой, нулловой, начинаться \ заканчиваться пробелами, не содержать слов (только знаки препинания \ спецсимволы), слова могут разделяться больше чем одним пробелом \ символами табуляции и т.д.

     */



    public static void main(String[] args) {




    }


  /*  public static int[][] method2(String str) {
        String s1 = "aabassrr";


        List<List<Integer>> result = new ArrayList<>();
        Arrays.asList(s1.toCharArray()).forEach(c -> {
            int integer = c[0];
            List<Integer> list = new ArrayList<>();
            list.add(integer);
            int count = (int) s1.chars().filter(ch -> ch == c[0]).count();
            list.add(count);
            result.add(list);
        });

        //int[] mas = Arrays
        //        .asList(s1.split(""))
        //        .stream()
        //        .distinct()
        //        .mapToInt(c -> c.charAt(0))
        //        .
    return (int[][]) result.toArray();
    }
*/

/*    public static boolean words(int charCode){
        final boolean words = (charCode == 39 ||
                charCode == 45 ||
                charCode == 95 ||
                (charCode > 47 && charCode < 58) ||
                (charCode > 64 && charCode < 91) ||
                charCode > 96 && charCode < 123);
        return words;
    }*/
​
    /*public static Map<Integer, Integer> wordsLength(String str) {
        return Arrays
                .asList(str.split("\\s*[^a-zA-Z0-9_\'-]\\s*"))
                .stream()
                .filter(item -> !item.isEmpty())
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().size()
                ));
    }*/
}
