package dk.jp;

import java.util.*;

public class Algorithm {
    private Integer[][] matrix = new Integer[20][20];
    private Integer row = 0;
    private Integer column = 0;
    private int maxRows = 0;

    public List<Integer> sort(List<Object> articles) {
        List<Integer> result = new ArrayList<>();
        for(Object el : articles) {
            if(el instanceof Integer) {
                matrix[row][column] = (Integer) el;
                column++;
            } else {
                row++;
                column = 0;
                iterate(el);
                column = 0;
                row = row + maxRows;
                maxRows = 0;
            }
        }

        for(int i = 0; i < 20; i++) {
            System.out.println("[" + (matrix[i] != null ? matrix[i] : "-") + "]");
            for(int j = 0; j < 20; j++) {
                System.out.print("[" + (matrix[i][j] != null ? matrix[i][j] : "-") + "]");
                if(matrix[i][j] != null) {
                    result.add(matrix[i][j]);
                }
            }
        }
        System.out.println("\n\n");
        return result;
    }

    private void iterate(Object el) {
        LinkedHashMap<String, List<?>> area = (LinkedHashMap) el;
        for(Object o : area.keySet()) {
            List<?> colList = area.get(o);

            int tmpRow = row;
            int tmpIndex = 0;
            for(Object item : colList) {
                if(item instanceof Integer) {
                    matrix[tmpRow][column] = (Integer) item;
                    tmpIndex++;
                    if(maxRows < tmpIndex) {
                        maxRows = tmpIndex;
                    }
                    tmpRow++;
                } else {
                    iterate(item);
                }
            }
            column++;
        }
    }

    public void clear() {
        matrix = new Integer[40][40];
        row = 0;
        column = 0;
        maxRows = 0;
    }
}