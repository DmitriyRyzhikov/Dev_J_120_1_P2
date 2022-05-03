package Dev_J_120;

import java.time.LocalTime;

public class Main {


    public static void main(String[] args) {
 
    /* Код полностью взят из первой части лаб.работы №3 курса 110
      и доработан для использования с разными типами данных.  
        
        Для опытов создано три разнотипных списка:
       - с типом данных String;
       - с типом данных Integer;
       - с типом данных LocalTime.
*/
        String[] stringData = {"кот", "лошадь", "корова", "обезьяна", "лебедь", "сова"}; 
        Integer[] intData = {100, 200, 300, 400, 500};
        LocalTime [] timeData = {LocalTime.MIDNIGHT, LocalTime.NOON, LocalTime.of(11, 45), LocalTime.of(9, 25), LocalTime.of(0, 15)}; 
        
        SinglyLinkedList<String> stringList = new SinglyLinkedList<>();
        stringList.addFromArray(stringData); 
        
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<>();
        intList.addFromArray(intData);
        
        SinglyLinkedList<LocalTime> timeList = new SinglyLinkedList<>();
        timeList.addFromArray(timeData);

        // метод printAllList() выводит содержимое всех трех списков в консоль:
        stringList.printAllList();
        intList.printAllList();
        timeList.printAllList();
        System.out.println();
        
    //перебираем при помощи оператора «for-each» все содержимое списка:
        for(LocalTime t : timeList){
            System.out.print(t + " ");
        }
        System.out.println();
    /*перебираем при помощи оператора «for-each» содержимое списка от головного узла до узла 
     с заданным значением; если список заданного значения не содержит, то должно быть перебрано всё содержимое списка.
     Это можно сделать прямо здесь вот так:
        
        for(Integer i : intList){
            System.out.print(i + " ");
            if(i.equals(300))
                break;
        }
     либо, используя перегруженный стандартный метод forEach, в который добавлен параметр T toElement до совпадения с которым
     будет происходить перебор списка.   
    */    
        intList.forEach(300, System.out::println);
    
        System.out.println();
        
        
    /*перебираем при помощи оператора «for-each» содержимое списка от узла с заданным значением 
     до конца списка; если список заданного значения не содержит, то ничего происходить не должно. 
     Это можно сделать прямо здесь вот так:
        
        boolean a = false;
        for(String s : stringList){
            if(s.equals("корова") == a) 
                continue;
            a = true;
            System.out.print(s + " ");
        }
    либо, используя перегруженный стандартный метод forEach, в который добавлен параметр T fromElement после совпадения с которым
    будет происходить заданное действие (список перебирается весь, но заданное действие происходит после совпадения элемента с параметром fromElement.     
    */
    stringList.forEach(x -> System.out.print(x.toUpperCase() + "; "), "корова");
    
        System.out.println();   
    }
}