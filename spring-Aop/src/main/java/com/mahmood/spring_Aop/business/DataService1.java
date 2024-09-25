package com.mahmood.spring_Aop.business;


import com.mahmood.spring_Aop.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    @TrackTime
    public int[] retrieveData(){
        return new int[] {11, 22, 33, 44, 55};
    }
}
