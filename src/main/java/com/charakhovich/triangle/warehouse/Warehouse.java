package com.charakhovich.triangle.warehouse;

import com.charakhovich.triangle.entity.TriangleParams;

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

    public boolean add(long id, TriangleParams triangleParams) {
        return (this.warehouseTriangleParams.put(id, triangleParams) != null);
    }

    public boolean update(long id, TriangleParams triangleParams) {
        return (this.warehouseTriangleParams.replace(id, triangleParams) != null);
    }

}
