package com.mahmood.spring_Aop.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BusinessMockTest {

    @Mock
    private DataService1 dataService1Mock;

    @InjectMocks
    private BusinessService1 businessService1;

    @Test
    void findTheMax(){

        DataService1 dataServiceMock = mock(DataService1.class);
        when(dataServiceMock.retrieveData()).thenReturn(new int[] {1, 3, 4, 5});

        BusinessService1 businessService1 = new BusinessService1(dataServiceMock);
        assertEquals(5, businessService1.calculateMax() );
    }

    @Test
    void findZeroUsingAnnotations(){

        when(dataService1Mock.retrieveData()).thenReturn(new int[] {});

        assertEquals(0, businessService1.calculateMax());

    }
}
