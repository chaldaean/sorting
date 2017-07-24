package dk.jp;

import java.util.*;

public class Algorithm {
    public List<Integer> sort(List<Object> articles) {
        List<Integer> result = new ArrayList<>();

        Integer[][] matrix = new Integer[100][100];
        int row = 0;
        int column =0;

        for(Object el: articles) {
            if(el instanceof Integer) {
                matrix[row][column] = (Integer) el;
                row++;
            } else {
                LinkedHashMap<String, List<?>> area = (LinkedHashMap) el;
                Iterator iterator = area.keySet().iterator();
                while(iterator.hasNext()){
                    List<?> colList = area.get(iterator.next());
                    row = 0;
                    column ++;
                    for(Object item : colList){
                        if(item instanceof Integer){
                            matrix[row][column] = (Integer) item;
                            row++;
                        }
                    }
                }
            }
        }


        for(int i =0; i < 100; i ++) {
            for(int j =0; j < 100; j ++) {
                if(matrix[i][j] != null) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }


}
