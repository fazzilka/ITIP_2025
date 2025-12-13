package LR_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "text.txt";
        File file = new File(filePath);
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Integer> words = new HashMap<>();
        while (scanner.hasNext()){
            String word = scanner.next().toLowerCase();

            word = word.replaceAll("[^a-zA-Zа-яА-Я0-9]", "");

            if (word.isEmpty()) {
                continue;
            }

            if (words.containsKey(word)){
                words.put(word, words.get(word)+1);
            } else {
                words.put(word, 1);
            }
        }
        scanner.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        list.addAll(words.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // return o2.getValue()-o1.getValue();
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        for (int i = 0; i < Math.min(10, list.size()); i++) {
            System.out.println(i + 1 + ". " + list.get(i).getKey() + " -> " + list.get(i).getValue());
        }
    }
}
