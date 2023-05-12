package com.monsanto.mbt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Shipment {
    public static List<Widget> myWidgets = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("Select the choice\n1. Create Widgets\n2. Ship Widget\n3. Exit");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    myWidgets = WidgetUtils.createWidget(myWidgets);
                    break;
                case 2:
                    WidgetUtils.shipWidget(myWidgets);
                    break;
                default:
                    break;
            }
        } while(choice!=3);
    }

}
