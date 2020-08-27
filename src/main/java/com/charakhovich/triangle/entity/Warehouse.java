package com.charakhovich.triangle.entity;

import java.util.Collections;
import java.util.HashMap;

public class Warehouse {
    private HashMap<Long, TriangleParams> warehouseTriangleParams;

    private static class SingletonHolder {
        static final Warehouse HOLDER_INSTANCE = new Warehouse();
    }

    public static Warehouse getInstance() {
        return Warehouse.SingletonHolder.HOLDER_INSTANCE;
    }

    private Warehouse() {
        this.warehouseTriangleParams = new HashMap<>();
    }

    public TriangleParams get(Long key) {
        return warehouseTriangleParams.get(key);
    }

    public TriangleParams put(Long key, TriangleParams value) {
        return warehouseTriangleParams.put(key, value);
    }

    public TriangleParams remove(Long key) {
        return warehouseTriangleParams.remove(key);
    }

    public HashMap<Long, TriangleParams> getWarehouseTriangleParams(){
        return (HashMap<Long, TriangleParams>) Collections.unmodifiableMap(warehouseTriangleParams);
    }


}
