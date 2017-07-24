package dk.jp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.*;


@RunWith(JUnit4.class)
public class AlgorithmTest {
    Algorithm algorithm = new Algorithm();
    List<Object> articles = new ArrayList<>();

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
    public void sort_two_areas() {
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
}