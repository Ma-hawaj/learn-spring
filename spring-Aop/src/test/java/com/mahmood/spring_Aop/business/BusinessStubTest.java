package com.mahmood.spring_Aop.business;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BusinessStubTest {

    @Test
    void test(){
        DataServiceStub dataServiceStub = new DataServiceStub();
        BusinessService1 businessService1 = new BusinessService1(dataServiceStub);

        assertEquals(6, businessService1.calculateMax() );
    }
}


class DataServiceStub extends DataService1 {


    @Override
    public int[] retrieveData() {
        return new int[] { 1, 2, 3, 4, 5};
    }
}