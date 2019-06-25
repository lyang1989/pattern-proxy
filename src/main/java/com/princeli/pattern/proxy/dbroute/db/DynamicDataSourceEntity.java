package com.princeli.pattern.proxy.dbroute.db;

/**
 * @author : princeli
 * @version 1.0
 * @className DynamicDataSourceEntity
 * @date 2019-06-23 19:55
 * @description: TODO
 */
public class DynamicDataSourceEntity {

    public final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> local = new ThreadLocal<String>();

    public DynamicDataSourceEntity() {
    }

    public static ThreadLocal<String> get() {
        return local;
    }


    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }

    public static void set(String source){
        local.set(source);
    }


    public static void set(int year){
        local.set("DB_"+year);
    }

}
