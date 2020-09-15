package com.charakhovich.triangle.obsever.impl;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.entity.TriangleParams;
import com.charakhovich.triangle.entity.Warehouse;
import com.charakhovich.triangle.obsever.Observer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleObserver implements Observer {
    static final Logger logger = LogManager.getLogger(TriangleObserver.class);
    private TriangleAction triangleAction = TriangleAction.getInstance();
    private Warehouse warehouse = Warehouse.getInstance();
    static final String SPLITTER = "\\s";

    @Override
    public void actionPerformed(Triangle triangle) {
        double square = triangleAction.square(triangle);
        double perimeter = triangleAction.perimeter(triangle);
        TriangleParams triangleParams = new TriangleParams(perimeter, square);
        warehouse.put(triangle.getId(), triangleParams);
        logger.log(Level.INFO, "Change warehouse:" + triangle.toString() + SPLITTER + triangleParams);
    }
}
