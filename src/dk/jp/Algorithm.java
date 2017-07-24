package dk.jp;

import java.util.*;

public class Algorithm {
    public List<Integer> sort(List<Object> articles) {
        List<Integer> result = new ArrayList<>();

        Integer[][] matrix = new Integer[50][50];
        Integer row = 0;
        Integer column = 0;

//        for(Object el: articles) {
//            iterate(el, matrix, row, column);
//        }
        //iterate(articles, matrix, row, column);
        for(Object el: articles) {
            if(el instanceof Integer) {
                matrix[row][column] = (Integer) el;
                column++;
            } else {
                LinkedHashMap<String, List<?>> area = (LinkedHashMap) el;

                row ++;
                column = 0;

                int arrSize = 0;
                int maxRows = 0;
                for(Object o : area.keySet()) {
                    arrSize++;
                    List<?> colList = area.get(o);

                    int tmpRow = row;

                    for(Object item : colList) {
                        if(item instanceof Integer) {
                            matrix[tmpRow][column] = (Integer) item;
                            if(maxRows < tmpRow){
                                maxRows = tmpRow;
                            }
                            tmpRow++;
                        } else {


                            LinkedHashMap<String, List<?>> map = (LinkedHashMap) item;

                            int arrSize_ = 0;
                            int maxRows_ = 0;
                            for(Object obj : map.keySet()) {
                                arrSize_++;
                                List<?> colList_ = map.get(obj);

                                tmpRow = row;

                                for(Object item_ : colList_) {
                                    if(item_ instanceof Integer) {
                                        matrix[tmpRow][column] = (Integer) item_;
                                        if(maxRows_ < tmpRow){
                                            maxRows_ = tmpRow;
                                        }
                                        tmpRow++;
                                    }
                                }
                                column++;
                                if(arrSize_ == map.keySet().size()) {
                                    column = 0;
                                    row = row + maxRows_;
                                }
                            }


                        }
                    }
                    column++;
                    if(arrSize == area.keySet().size()) {
                        column = 0;
                        row = row + maxRows;
                    }
                }

            }
        }
//



        for(int i =0; i < 50; i ++) {

            System.out.println("[" + (matrix[i] != null ? matrix[i] : "-") + "]");

            for(int j =0; j < 50; j ++) {
                System.out.print("[" + (matrix[i][j] != null ? matrix[i][j] : "-") + "]");
                if(matrix[i][j] != null) {


                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }


    private void iterate(Object el, Integer[][] matrix, Integer row, Integer column){
            if(el instanceof Integer) {
                matrix[row][column] = (Integer) el;
                column++;
            } else {
                LinkedHashMap<String, List<?>> area = (LinkedHashMap) el;

                row ++;
                column = 0;

                Integer arrSize = 0;
                Integer maxRows = 0;
                for(Object o : area.keySet()) {
                    arrSize++;
                    List<?> colList = area.get(o);

                    Integer tmpRow = row;

                    for(Object item : colList) {
                        if(item instanceof Integer) {
                            matrix[tmpRow][column] = (Integer) item;
                            if(maxRows < tmpRow){
                                maxRows = tmpRow;
                            }
                            tmpRow++;
                        } else {

                                iterate( item, matrix, tmpRow, column);
                                tmpRow++;

                        }
                    }
                    column++;
                    if(arrSize == area.keySet().size()) {
                        column = 0;
                        row = row + maxRows;
                    }
                }

            }
    }
}
