package com.mahmood.spring_Aop.business;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusinessMockTest {

    @Test
    void findTheMax(){

        DataService1 dataServiceMock = mock(DataService1.class);
        when(dataServiceMock.retrieveData()).thenReturn(new int[] {1, 3, 4, 5});

        BusinessService1 businessService1 = new BusinessService1(dataServiceMock);
        assertEquals(5, businessService1.calculateMax() );
    }
}
