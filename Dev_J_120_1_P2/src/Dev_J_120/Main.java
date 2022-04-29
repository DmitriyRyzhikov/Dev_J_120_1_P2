package Dev_J_120;

import java.time.LocalTime;
import java.util.function.UnaryOperator;
import sun.net.www.content.audio.x_aiff;

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
     с заданным значением; если список заданного значения не содержит, то должно быть перебрано всё содержимое списка*/
        for(Integer i : intList){
            System.out.print(i + " ");
            if(i.equals(300))
                break;
        }
        System.out.println();
    /*перебираем при помощи оператора «for-each» содержимое списка от узла с заданным значением 
     до конца списка; если список заданного значения не содержит, то ничего происходить не должно.*/    
        boolean a = false;
        for(String s : stringList){
            if(s.equals("лебедь") == a) 
                continue;
            a = true;
            System.out.print(s + " ");
        }
        System.out.println();
        
        
/* Список доступных методов:
        - Метод addFirst(T data) добавляет данные в начало списка;
        - Метод addFromArray(T[] data) добавляет данные в начало списка из массива с сохранением порядка.
        - Метод extractFirst() извлекает и возвращает значение из начала списка без его удаления из списка;
        - Метод extractFirstAndRemove() извлекает и возвращает значение из начала списка с удалением его из списка;
        - Метод addToTail(T data) добавляет данные в конец списка;
        - Метод extractTailData() извлекает и возвращает значение из конца списка без его удаления;
        - Метод extractTailAndRemove() извлекает и возвращает значение из конца списка с удалением его из списка;
        - Метод isInList(T toEquals) определяет, содержит ли список переданное в метод значение toEquals, или нет. 
          Возвращает true, если содержит и false, если такого значение в списке нет;
        - Метод isEmpty(), определяющий, является ли список пустым, или нет. 
          Возвращает true, если список пустой и false, если не пустой;
        - Метод printAllList() - осуществляет печать всех значений списка. 
          Если список пустой, выводит сообщение "Элементы списка отсутствуют, список пустой.";
        - *Метод removeIfHas(T toRemove) удаляет переданное в метод значение toRemove из списка. 
          Если значения в списке нет, то ничего происходить не должно; 
        - Метод countElements(), возвращающий количество элементов списка.
*/        
    }
}