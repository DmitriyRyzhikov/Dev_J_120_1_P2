package Dev_J_120;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;


public class SinglyLinkedList <T> implements Iterable<T> {

    private Node first; //изначально null
  
    //Метод добавляет данные в начало списка.
    public void addFirst(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.toNext = first;
        first = newNode;
    }
    
    //Метод добавляет данные в начало списка из массива с сохранением порядка.
    public void addFromArray(T[] data) {
        for (T s : data) {
            Node newNode = new Node();
            newNode.data = s;
            if (isEmpty()) {
                addFirst(s);
            } else if (first.toNext == null) {
                first.toNext = newNode;
            } else {
                Node current = first;
                while (current.toNext != null) {
                    current = current.toNext;
                }
                current.toNext = newNode;
            }
        }
    }

    //извлечение значения из начала списка без его удаления из списка
    public T extractFirst() {
        if (!isEmpty())
            return (T)first.data;
        else
            throw new NullPointerException("Список пустой.");       
    }

    //Извлечение значения из начала списка с удалением его из списка
    public T extractFirstAndRemove() {
        if (!isEmpty()) {
            T firstNodeData = (T)first.data;
            first = first.toNext;
            return firstNodeData;  }
        else
            throw new NullPointerException("Список пустой.");
    }

    //добавление значения в конец списка
    public void addToTail(T data) {
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) {
            addFirst(data);
        } else if (first.toNext == null) {
            first.toNext = newNode;
        } else {
            Node current = first;
            while (current.toNext != null) {
                current = current.toNext;
            }
            current.toNext = newNode;
        }
    }

    //извлечение значения из конца списка без его удаления
    public T extractTailData() {
        if (!isEmpty()) {
            Node current = first;
            while (current.toNext != null) {
                   current = current.toNext; }
            return (T)current.data; }        
        else
            throw new NullPointerException("Список пустой.");   
    }

    //извлечение значения из конца списка с удалением
    public T extractTailAndRemove() {

        if (!isEmpty() && first.toNext == null) {
            T data = (T)first.data;
            first = null;
            return data; }

        else if (!isEmpty() && first.toNext != null) {
            Node current = first;
            Node temp = first;
            while (current.toNext != null) {
                  temp = current;
                  current = current.toNext;
                }
            T data = (T)current.data;
            current = temp;
            current.toNext = null;
            return data;    
        }
        else 
            throw new NullPointerException("Список пустой.");
    }
    
    //Метод, определяющий, содержит ли список заданное значение, или нет

    public boolean isInList(T toEquals) {
        
        Node current = first;
        Boolean result = false;
        
        if (current == null) 
            return false;
        else if (current.toNext == null) {
            return toEquals.equals(current.data);
        } 
        else 
        {
            while (current.toNext != null) {
                if (toEquals.equals(current.data)) {
                    result = true;
                    current = current.toNext;
                } 
                else 
                    current = current.toNext;                
            }
            if (toEquals.equals(current.data)) 
                result = true;            
        return result;
        }
    }
    
       //Метод, определяющий, является ли список пустым, или нет;
    
    public boolean isEmpty() {
        return first == null;
    }

    //печать всех значений списка
    public void printAllList() {
        Node current = first;
        if (current == null) {
            System.out.println("Элементы списка отсутствуют, список пустой.");
        } else if (current.toNext == null) {
            current.printNodeData();
            System.out.println();
        } else {
            while (current.toNext != null) {
                current.printNodeData();
                current = current.toNext;
                if (current.toNext == null) {
                    current.printNodeData();
                }
            }
            System.out.println();
        }
    }

    //Метод удаляющий заданное значение из списка; если значения в списке нет, то ничего происходить не должно.
    public void removeIfHas(T toRemove) {

        if (!isEmpty()) {
            if (first.toNext != null) {
                if (toRemove.equals(first.data)) {
                    first = first.toNext;
                    //return; 
                }
                Node current = first;
                while (current.toNext != null) {
                    if (toRemove.equals(current.toNext.data)) {
                        current.toNext = current.toNext.toNext;
                        //return; 
                        //Сейчас удаляет все одинаковые искомые элементы, если одинаковых искомых элементов несколько. 
                        //Если нужно удалить единожды первый встретившийся - убрать коммент с return.
                    } 
                    else {
                        current = current.toNext;
                    }
                }
            } 
            else {
                if (toRemove.equals(first.data)) {
                    first = null;
                }
            }
        }
    }
    
    //Метод, возвращающий количество элементов списка.
    public int countElements() {
        Node current = first;
        if (current == null) {
            return 0;
        } else if (current.toNext == null) {
            return 1;
        } else {
            int count = 0;
            while (current.toNext != null) {
                current = current.toNext;
                count++;
                if (current.toNext == null) {
                    count++;
                }
            }
            return count;
        }
    }
    @Override
    public Iterator iterator() {
        return new MyIterator<T>(first); 
    }
    public void myForEach(T element, Consumer<T> c){
        for(T t : this){  
         c.accept(t);  
            if(t.equals(element))
                break;   
        }
    }


// вложенный класс Node  в сущностях которого хранятся данные и ссылка на следующий узел.
    class Node <T> {

        private T data;
        private Node toNext;

        public void printNodeData() {
            System.out.print(data + "; ");
        }
    }
    // вложенный класс MyIterator.
    class MyIterator<T> implements Iterator<T> {
        
        private Node hasNode;
        
        public MyIterator(Node hasNode) {
            this.hasNode = hasNode;
        }

        @Override
        public boolean hasNext() {
          return hasNode != null;
        }

        @Override
        public T next() {
           if(hasNode == null) throw new NoSuchElementException();
              T res = (T) hasNode.data;
              hasNode = hasNode.toNext;
              return res;
        }
        
    }
}
