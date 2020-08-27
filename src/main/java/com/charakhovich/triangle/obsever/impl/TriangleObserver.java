package com.charakhovich.triangle.obsever.impl;

import com.charakhovich.triangle.action.TriangleAction;
import com.charakhovich.triangle.obsever.Observer;
import com.charakhovich.triangle.entity.Triangle;
import com.charakhovich.triangle.entity.TriangleParams;
import com.charakhovich.triangle.entity.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleObserver implements Observer {
    static final Logger logger= LogManager.getLogger();
    static TriangleAction triangleAction = new TriangleAction();
    @Override
    public void actionPerformed(Triangle triangle){
       /* if (!(shape instanceof Triangle)){
            throw new TriangleException("This shape isn't object of class Triangle");
        }
        Triangle triangle=(Triangle)shape;*/
        double square=triangleAction.square(triangle);
        double perimeter=triangleAction.perimeter(triangle);
        Warehouse.getInstance().put(triangle.getId(), new TriangleParams(perimeter,square));
    }
}
