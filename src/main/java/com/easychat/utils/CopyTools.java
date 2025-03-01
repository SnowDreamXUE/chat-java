package com.easychat.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CopyTools {
    public static <T,S>List<T> copyList(List<S> sourceList, Class<T> targetClass){
        List<T> list = new ArrayList<>();
        for(S source : sourceList){
            T target = null;
            try {
                target = targetClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(source, target);
            list.add(target);
        }
        return list;
    }

    public static <T,S>T copy(S source, Class<T> targetClass){
        T target = null;
        try {
            target = targetClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
