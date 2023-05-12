package com.monsanto.mbt;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ShipmentTest {

    private static List<Widget> myWidgets = WidgetUtils.getSampleWidgets();

    @Test
    public void testShipment_Sorted_By_Color(){
        //Implement your solution to get list of shipments
        WidgetUtils.sortByColor(myWidgets);
    }

    @Test
    public void testShipment_Sorted_By_Date(){
        //Implement your solution to get list of shipments
        WidgetUtils.sortByProductionDate(myWidgets);
    }


}
