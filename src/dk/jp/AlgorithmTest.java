package dk.jp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;


@RunWith(JUnit4.class)
public class AlgorithmTest {
    private Algorithm algorithm = new Algorithm();
    private List<Object> articles = new ArrayList<>();

    @Before
    public void setUp() {
        articles.clear();
        Algorithm.matrix = new Integer[60][60];
        Algorithm.row = 0;
        Algorithm.column = 0;
    }

    @Test
    public void sort_only_articles() {
        articles.add(0);
        articles.add(1);
        articles.add(2);
        articles.add(3);

        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i < articles.size(); i++) {
            Assert.assertEquals(i, result.get(i).intValue());
        }
    }

    @Test
    public void sort_one_area() {
        articles.add(0);

        Map<String, List<?>> area = new LinkedHashMap<>();
        List<Integer> col1 = Arrays.asList(1, 2);
        area.put("col1", col1);

        articles.add(area);
        articles.add(3);
        articles.add(4);

        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i < result.size(); i++) {
            Assert.assertEquals(i, result.get(i).intValue());
        }
    }

    @Test
    public void sort_one_area_with_two_columns() {
        articles.add(0);

        Map<String, List<?>> area = new LinkedHashMap<>();
        List<Integer> col1 = Arrays.asList(1, 3);
        List<Integer> col2 = Arrays.asList(2, 4);
        area.put("col1", col1);
        area.put("col2", col2);

        articles.add(area);
        articles.add(5);
        articles.add(6);
        articles.add(7);

        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i < result.size(); i++) {
            Assert.assertEquals(i, result.get(i).intValue());
        }
    }

    @Test
    public void sort_one_areas_with_three_columns_different_size_small_first() {
        articles.add(0);

        Map<String, List<?>> area = new LinkedHashMap<>();
        List<Integer> col1 = Arrays.asList(1, 4, 6);
        List<Integer> col2 = Collections.singletonList(2);
        List<Integer> col3 = Arrays.asList(3, 5, 7, 8, 9, 10);
        area.put("col1", col1);
        area.put("col2", col2);
        area.put("col3", col3);

        articles.add(area);
        articles.add(11);
        articles.add(12);

        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i < result.size(); i++) {
            Assert.assertEquals(i, result.get(i).intValue());
        }
    }


    @Test
    public void sort_one_areas_with_three_columns_different_size_large_first() {
        articles.add(0);
        articles.add(1);
        articles.add(2);

        Map<String, List<?>> area = new LinkedHashMap<>();
        List<Integer> col1 = Arrays.asList(3, 6, 8, 10, 11, 12);
        List<Integer> col2 = Collections.singletonList(4);
        List<Integer> col3 = Arrays.asList(5, 7, 9);
        area.put("col1", col1);
        area.put("col2", col2);
        area.put("col3", col3);

        articles.add(area);
        articles.add(13);
        articles.add(14);

        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i < result.size(); i++) {
            Assert.assertEquals(i, result.get(i).intValue());
        }
    }

    @Test
    public void sort_two_areas_with_three_and_two_columns_different_size() {
        articles.add(0);

        Map<String, List<?>> area0 = new LinkedHashMap<>();
        List<Integer> area0_col1 = Collections.singletonList(1);
        List<Integer> area0_col2 = Arrays.asList(2, 4, 6, 7);
        List<Integer> area0_col3 = Arrays.asList(3, 5);
        area0.put("col1", area0_col1);
        area0.put("col2", area0_col2);
        area0.put("col3", area0_col3);

        articles.add(area0);
        articles.add(8);

        Map<String, List<?>> area1 = new LinkedHashMap<>();
        List<Integer> area1_col1 = Arrays.asList(9, 11, 12);
        List<Integer> area1_col2 = Collections.singletonList(10);

        area1.put("col1", area1_col1);
        area1.put("col2", area1_col2);
        articles.add(area1);

        articles.add(13);

        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i < result.size(); i++) {

            Assert.assertEquals(i, result.get(i).intValue());
        }
    }

    @Test
    public void sort_two_areas_with_three_and_two_columns_different_size_and_three_article_areas_different_size() {
        articles.add(0);
        articles.add(1);
        articles.add(2);

        Map<String, List<?>> area0 = new LinkedHashMap<>();
        List<Integer> area0_col1 = Collections.singletonList(3);
        List<Integer> area0_col2 = Arrays.asList(4, 6, 8, 9);
        List<Integer> area0_col3 = Arrays.asList(5, 7);
        area0.put("col1", area0_col1);
        area0.put("col2", area0_col2);
        area0.put("col3", area0_col3);

        articles.add(area0);
        articles.add(10);
        articles.add(11);
        articles.add(12);
        articles.add(13);

        Map<String, List<?>> area1 = new LinkedHashMap<>();
        List<Integer> area1_col1 = Arrays.asList(14, 16, 17);
        List<Integer> area1_col2 = Collections.singletonList(15);

        area1.put("col1", area1_col1);
        area1.put("col2", area1_col2);
        articles.add(area1);

        articles.add(18);
        articles.add(19);

        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i < result.size(); i++) {

            Assert.assertEquals(i, result.get(i).intValue());
        }
    }

    @Test
    public void sort_one_area_with_embedded_area() {
        articles.add(0);
        articles.add(1);

        Map<String, List<?>> area0 = new LinkedHashMap<>();
        List<Integer> area0_col1 = Arrays.asList(2, 5, 8);

        Map<String, List<?>> area1_area2 = new LinkedHashMap<>();
        List<Integer> area1_area2_col1 = Arrays.asList(3, 6);
        List<Integer> area1_area2_col2 = Arrays.asList(4, 7);

        area1_area2.put("col1", area1_area2_col1);
        area1_area2.put("col2", area1_area2_col2);
        area0.put("col1", area0_col1);
        area0.put("col2", Arrays.asList(area1_area2));

        articles.add(area0);
        articles.add(9);
        articles.add(10);

        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i < result.size(); i++) {

            Assert.assertEquals(i, result.get(i).intValue());
        }
    }

    @Test
    public void sort_one_area_with_two_embedded_areas_different_size() {
        articles.add(0);
        articles.add(1);

        Map<String, List<?>> area0 = new LinkedHashMap<>();
        List<Integer> area0_col1 = Arrays.asList(2, 5, 8, 11, 13, 15, 16, 17);

        Map<String, List<?>> area1_area2 = new LinkedHashMap<>();
        List<Integer> area1_area2_col1 = Arrays.asList(3, 6, 9, 12, 14);
        List<Integer> area1_area2_col2 = Arrays.asList(4, 7, 10);

        area1_area2.put("col1", area1_area2_col1);
        area1_area2.put("col2", area1_area2_col2);
        area0.put("col1", area0_col1);
        area0.put("col2", Arrays.asList(area1_area2));

        articles.add(area0);
        articles.add(18);
        articles.add(19);

        Map<String, List<?>> area1 = new LinkedHashMap<>();
        List<Integer> area1_col1 = Arrays.asList(20, 25);
        List<Integer> area1_col2 = Arrays.asList(21, 26, 30, 33);
        List<Integer> area1_col3 = Arrays.asList(22, 27, 31);

        Map<String, List<?>> area1_col4 = new LinkedHashMap<>();
        List<Integer> area1_col4_col1 = Arrays.asList(23, 28, 32, 34, 35);
        List<Integer> area1_col4_col2 = Arrays.asList(24, 29);

        area1_col4.put("col1", area1_col4_col1);
        area1_col4.put("col2", area1_col4_col2);

        area1.put("col1", area1_col1);
        area1.put("col2", area1_col2);
        area1.put("col3", area1_col3);
        area1.put("col4", Arrays.asList(area1_col4));

        articles.add(area1);
        articles.add(36);
        articles.add(37);

        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i < result.size(); i++) {

            Assert.assertEquals(i, result.get(i).intValue());
        }
    }


    @Test
    public void sort_one_area_with_three_embedded_areas_different_size() {
        articles.add(0);
        articles.add(1);
        articles.add(2);

        Map<String, List<?>> area2 = new LinkedHashMap<>();
        List<Integer> area2_col1 = Arrays.asList(5);
        List<Integer> area2_col2 = Arrays.asList(6, 9, 11, 12);
        area2.put("col1", area2_col1);
        area2.put("col2", area2_col2);

        Map<String, List<?>> area1 = new LinkedHashMap<>();
        List<Integer> area1_col1 = Arrays.asList(4, 8, 10);
        List<?> area1_col2 = Arrays.asList(area2);
        area1.put("col1", area1_col1);
        area1.put("col2", area1_col2);

        Map<String, List<?>> area0 = new LinkedHashMap<>();
        List<Integer> area0_col1 = Arrays.asList(3, 7);
        List<?> area0_col2 = Arrays.asList(area1);

        area0.put("col1", area0_col1);
        area0.put("col2", area0_col2);

        articles.add(area0);
        articles.add(13);
        articles.add(14);

        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i < result.size(); i++) {
            Assert.assertEquals(i, result.get(i).intValue());
        }
    }

    @Test
    public void sort_1() {
        articles.add(0);
        articles.add(1);

        Map<String, List<?>> area1 = new LinkedHashMap<>();
        List<Integer> area1_col1 = Arrays.asList(2, 4, 5);
        area1.put("col1", area1_col1);

        Map<String, List<?>> area0 = new LinkedHashMap<>();
        List<?> area0_col1 = Arrays.asList(area1);
        List<Integer> area0_col2 = Arrays.asList(3);
        area0.put("col1", area0_col1);
        area0.put("col2", area0_col2);

        articles.add(area0);
        articles.add(6);
        articles.add(7);

        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i < result.size(); i++) {
            Assert.assertEquals(i, result.get(i).intValue());
        }
    }

    @Test
    public void sort_one_area_with_three_and_two_embedded_areas_different_size() {
        articles.add(0);
        articles.add(1);
        articles.add(2);

        Map<String, List<?>> area2 = new LinkedHashMap<>();
        List<Integer> area2_col1 = Arrays.asList(5);
        List<Integer> area2_col2 = Arrays.asList(6, 9, 11, 12);
        area2.put("col1", area2_col1);
        area2.put("col2", area2_col2);

        Map<String, List<?>> area1 = new LinkedHashMap<>();
        List<Integer> area1_col1 = Arrays.asList(4, 8, 10);
        List<?> area1_col2 = Arrays.asList(area2);
        area1.put("col1", area1_col1);
        area1.put("col2", area1_col2);

        Map<String, List<?>> area0 = new LinkedHashMap<>();
        List<Integer> area0_col1 = Arrays.asList(3, 7);
        List<?> area0_col2 = Arrays.asList(area1);

        area0.put("col1", area0_col1);
        area0.put("col2", area0_col2);

        articles.add(area0);
        articles.add(13);
        articles.add(14);

        Map<String, List<?>> area6 = new LinkedHashMap<>();
        List<Integer> area6_col1 = Arrays.asList(20);
        area6.put("col1", area6_col1);

        Map<String, List<?>> area5 = new LinkedHashMap<>();
        List<Integer> area5_col1 = Arrays.asList(19, 24);
        List<?> area5_col2 = Arrays.asList(area6);
        area5.put("col1", area5_col1);
        area5.put("col2", area5_col2);

        Map<String, List<?>> area4 = new LinkedHashMap<>();
        List<Integer> area4_col1 = Arrays.asList(15, 21);
        List<Integer> area4_col2 = Arrays.asList(16);
        List<Integer> area4_col3 = Arrays.asList(17, 22, 25);
        area4.put("col1", area4_col1);
        area4.put("col2", area4_col2);
        area4.put("col3", area4_col3);

        Map<String, List<?>> area3 = new LinkedHashMap<>();
        List<?> area3_col1 = Arrays.asList(area4);
        List<Integer> area3_col2 = Arrays.asList(18, 23, 26, 27);
        List<?> area3_col3 = Arrays.asList(area5);
        area3.put("col1", area3_col1);
        area3.put("col2", area3_col2);
        area3.put("col3", area3_col3);

        articles.add(area3);
        articles.add(28);
        articles.add(29);


        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i < result.size(); i++) {
            Assert.assertEquals(i, result.get(i).intValue());
        }
    }

}