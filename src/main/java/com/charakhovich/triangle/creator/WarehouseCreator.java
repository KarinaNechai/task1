package com.charakhovich.triangle.creator;

import com.charakhovich.triangle.entity.Shape;

public interface WarehouseCreator<T extends Shape>{
     boolean createWarehouse(T t);
}
