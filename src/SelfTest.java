import java.util.Iterator;
import java.util.TreeMap;

public class SelfTest {
    public static void main(String[] args) {
        TreeMap<String, Integer> dic = new TreeMap<>();
        dic.put("Irving", 3);
        dic.put("Yarly", 7);
        dic.put("Pipi", 2);
        Iterator<String > iterator = dic.keySet().iterator();
        while (iterator.hasNext()){
            String name = iterator.next();
            if ("Yarly".equals(name)){
                iterator.remove();
            }
        }

        for (String name : dic.keySet()) {
            int num = dic.get(name);
            System.out.println("name: " + name + "\tnum: " + num);
        }

//        System.out.println((int) Math.pow(2, 0));
//        System.out.println(Math.sqrt(8));
//        System.out.println(findExponent(8));
//        ;
    }

    private static int findExponent(int i) {
        if (i == 1) {
            return 0;
        }
        return 1 + findExponent(i / 2);
    }
}
