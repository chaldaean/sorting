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
    }

    @Test
    public void sort_only_articles() {
        articles.add(0);
        articles.add(1);
        articles.add(2);
        articles.add(3);

        List<Integer> result = algorithm.sort(articles);

        for(int i = 0; i<articles.size(); i++) {
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

        for(int i = 0; i<result.size(); i++) {
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

        for(int i = 0; i<result.size(); i++) {
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

        for(int i = 0; i<result.size(); i++) {
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

        for(int i = 0; i<result.size(); i++) {
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

        for(int i = 0; i<result.size(); i++) {

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

        for(int i = 0; i<result.size(); i++) {

            Assert.assertEquals(i, result.get(i).intValue());
        }
    }

}