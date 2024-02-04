package com.example.junit.hamcrestTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

public class HamcrestTest {

    private List<String> values;

    @Before
    public void setUpList(){
        values = new ArrayList<String>();
        values.add("x");
        values.add("y");
        values.add("z");
    }

    @Test
    public void testWithoutHamcrest(){
        Assert.assertTrue(values.contains("one") || values.contains("two") || values.contains("tree"));
    }

    @Test
    public void testWithHamcrest(){
        Assert.assertThat(values,hasItem(anyOf(equalTo("one"),equalTo("two"),equalTo("tree"))));
    }

}
