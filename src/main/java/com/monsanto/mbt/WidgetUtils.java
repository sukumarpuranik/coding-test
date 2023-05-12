package com.monsanto.mbt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class WidgetUtils {

    private static Scanner sc = new Scanner(System.in);
    public static List<Widget> getSampleWidgets() {
        List<Widget> widgets = new ArrayList<Widget>();

        widgets.add(new Widget(1, "Red", stringToDateConverter("01-01-2006")));
        widgets.add(new Widget(2, "Blue",  stringToDateConverter("02-03-2007")));
        widgets.add(new Widget(3, "Red",  stringToDateConverter("03-09-2006")));
        widgets.add(new Widget(4, "Green", stringToDateConverter( "04-01-2009")));
        widgets.add(new Widget(5, "Green",  stringToDateConverter("05-07-2011")));
        widgets.add(new Widget(6, "Blue", stringToDateConverter( "06-02-2016")));
        widgets.add(new Widget(7, "Green",  stringToDateConverter("07-01-2008")));
        widgets.add(new Widget(8, "Blue",  stringToDateConverter("08-02-2009")));
        widgets.add(new Widget(9, "Red",  stringToDateConverter("09-01-2005")));
        widgets.add(new Widget(10, "Blue",  stringToDateConverter("01-03-2013")));
        widgets.add(new Widget(11, "Green", stringToDateConverter( "02-01-2015")));
        widgets.add(new Widget(12, "Green", stringToDateConverter( "03-01-2012")));
        widgets.add(new Widget(13, "Red", stringToDateConverter( "04-01-2014")));
        widgets.add(new Widget(14, "Green",  stringToDateConverter("04-07-2009")));
        widgets.add(new Widget(15, "Red", stringToDateConverter( "05-01-2011")));
        widgets.add(new Widget(16, "Red",  stringToDateConverter("06-01-2016")));
        widgets.add(new Widget(17, "Red",  stringToDateConverter("07-01-2008")));
        widgets.add(new Widget(18, "Green", stringToDateConverter( "08-08-2009")));
        widgets.add(new Widget(19, "Red",  stringToDateConverter("09-01-2005")));
        widgets.add(new Widget(20, "Blue",  stringToDateConverter("01-05-2017")));
        widgets.add(new Widget(21, "Red",  stringToDateConverter("01-12-2006")));
        widgets.add(new Widget(22, "Blue",  stringToDateConverter("02-13-2007")));
        widgets.add(new Widget(23, "Red",  stringToDateConverter("03-14-2006")));
        widgets.add(new Widget(25, "Green",  stringToDateConverter("05-16-2011")));
        widgets.add(new Widget(24, "Red",  stringToDateConverter("04-15-2009")));

        return widgets;
    }

    public static Date stringToDateConverter(String strDate){
        Date parsedDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        try {
            parsedDate = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate;
    }
    public static List<Widget> createWidget(List<Widget> myWidgets) {
        System.out.println("Create Widget");
        if(myWidgets.size()>10) {
            System.out.println("Total widget count 10 or above, so new widgets cannot be created");
            return null;
        }
        else {
            myWidgets.add(generateNewWidget());
            return myWidgets;
        }
    }
    public static void shipWidget(List<Widget> myWidgets) {
        System.out.println("Ship Widget");
        if(myWidgets.size()<1)
            System.out.println("No widgets found to ship");
        else {
            int choice = 0;
            do {
                System.out.println("Select the choice\n1. Sort By Color\n2. Sort by Production Date\n3. Exit");
                choice = sc.nextInt();
                switch(choice) {
                    case 1:
                        sortByColor(myWidgets);
                        break;
                    case 2:
                        sortByProductionDate(myWidgets);
                        break;
                    default:
                        break;
                }
            } while(choice!=3);
        }
    }
    public static Widget generateNewWidget() {
        System.out.println("Enter serial no, color, createdDate");
        int serialNo = sc.nextInt();
        sc.nextLine();
        String color = sc.nextLine();
        Date productionDate = WidgetUtils.stringToDateConverter(sc.nextLine());
        return new Widget(serialNo, color, productionDate);
    }
    public static void sortByColor(List<Widget> myWidgets) {
        myWidgets = myWidgets.stream().sorted(Comparator.comparing(Widget::getColor)).collect(Collectors.toList());
        for (Widget widget: myWidgets)
            System.out.println(widget.toString());
    }
    public static void sortByProductionDate(List<Widget> myWidgets) {
        myWidgets = myWidgets.stream().sorted(Comparator.comparing(Widget::getProductionDate)).collect(Collectors.toList());
        for (Widget widget: myWidgets)
            System.out.println(widget.toString());
    }
}
