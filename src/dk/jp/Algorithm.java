package dk.jp;

import java.util.*;

public class Algorithm {
    static Integer[][] matrix = new Integer[60][60];
    static Integer row = 0;
    static Integer column = 0;
    static int maxRows = 0;

    public List<Integer> sort(List<Object> articles) {
        List<Integer> result = new ArrayList<>();
        for(Object el : articles) {
            if(el instanceof Integer) {
                matrix[row][column] = (Integer) el;
                column++;
            } else {
                row++;
                column = 0;
                iterate(el, true);
            }
        }

        for(int i = 0; i < 60; i++) {
            System.out.println("[" + (matrix[i] != null ? matrix[i] : "-") + "]");
            for(int j = 0; j < 60; j++) {
                System.out.print("[" + (matrix[i][j] != null ? matrix[i][j] : "-") + "]");
                if(matrix[i][j] != null) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }

    private void iterate(Object el, boolean end) {
        LinkedHashMap<String, List<?>> area = (LinkedHashMap) el;
        int arrSize = 0;
        maxRows = 0;
        for(Object o : area.keySet()) {
            arrSize++;
            List<?> colList = area.get(o);

            int tmpRow = row;
            for(Object item : colList) {
                if(item instanceof Integer) {
                    matrix[tmpRow][column] = (Integer) item;
                    if(maxRows < tmpRow) {
                        maxRows = tmpRow;
                    }
                    tmpRow++;
                } else {
                    iterate(item, (arrSize == area.keySet().size()));
                }
            }
            column++;
            if((arrSize == area.keySet().size()) && end) {
                column = 0;
                row = row + maxRows;
            }
        }
    }
}