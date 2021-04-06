package com.coldsmog.luckinmap.finder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RegionFinderTest {

    @Test
    public void getProvince() {
        RegionFinder.getProvince();
    }

    @Test
    public void getCity() {
        RegionFinder.getCity("天津市");
    }

    @Test
    public void getRegion() {
        RegionFinder.getRegion("天津市","全部");
    }


}
