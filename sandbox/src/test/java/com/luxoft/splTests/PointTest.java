package com.luxoft.splTests;

import com.luxoft.sql.Point;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class PointTest {

    @Test
    public void test(){

        Point p1 = new Point(1, 3);
        Point p2 = new Point(1, 5);
        Assert.assertEquals( p1.distance(p2),2.0, "Расстояние между точками");
    }
}
