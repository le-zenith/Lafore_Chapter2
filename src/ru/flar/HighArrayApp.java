package ru.flar;

class HighArray {
    private long[] a; // Ссылка на массив a
    private int nElems; // Количество элементов в массиве

    //-----------------------------------------------------------
    public HighArray(int max) // Конструктор
    {
        a = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }

    public boolean find(long searchKey) { // Поиск заданного значения
        int j;
        for (j = 0; j < nElems; j++) // Для каждого элемента
            if (a[j] == searchKey) // Значение найдено?
                break; // Да - выход из цикла
        if (j == nElems) // Достигнут последний элемент?
            return false; // Да
        else
            return true; // Нет
    }

    //-----------------------------------------------------------
    public void insert(long value) // Вставка элемента в массив
    {
        a[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) // Поиск заданного значения
            if (value == a[j])
                break;
        if (j == nElems) // Найти не удалось
            return false;
        else // Значение найдено
        {
            for (int k = j; k < nElems; k++) // Сдвиг последующих элементов
                a[k] = a[k + 1];
            nElems--; // Уменьшение размера
            return true;
        }
    }

    //-----------------------------------------------------------
    public void display() // Вывод содержимого массива
    {
        for (int j = 0; j < nElems; j++) // Для каждого элемента
            System.out.print(a[j] + " "); // Вывод
        System.out.println("");
    }

    public long getMax() {
        long max = Long.MIN_VALUE;
        if (nElems == 0) {
            return -1;
        } else {
            for (int i = 0; i < nElems; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
            }
        }
        return max;
    }

    private void removeByIndex(int index) {
        for (int i = index; i < nElems; i++) {
            a[i] = a[i+1];
        }
        nElems--;
    }

    public void noDuplicates() {
        long currentValue;
        for (int i = 0; i < nElems; i++) {
            currentValue = a[i];
            for (int j = i + 1; j < nElems; j++) {
                if (a[i] == a[j]) {
                    removeByIndex(j);
                }
            }
        }
    }

    public long removeMax() {
        long max = Long.MIN_VALUE;
        int indexMax = 0;
        if (nElems == 0) {
            return -1;
        } else {
            for (int i = 0; i < nElems; i++) {
                if (a[i] > max) {
                    indexMax = i;
                    max = a[i];
                }
            }
        }
        for (int i = indexMax; i < nElems; i++) {
            a[i] = a[i+1];
        }
        nElems--;
        return max;
    }
//-----------------------------------------------------------
} // Конец класса HighArray

////////////////////////////////////////////////////////////////
//-----------------------------------------------------------
public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100; // Размер массива
        HighArray arr; // Ссылка на массив
        arr = new HighArray(maxSize); // Создание массива
        arr.insert(77); // Вставка 10 элементов
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.insert(88);
        arr.insert(77);
        arr.insert(11);
        arr.display(); // Вывод элементов
        arr.noDuplicates();
        System.out.println("After removing duplicates:");
        arr.display();
        int searchKey = 35; // Поиск элемента
        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);
        arr.delete(00); // Удаление трех элементов
        arr.delete(55);
        arr.delete(99);
        arr.display(); // Повторный вывод
        System.out.println("Max: " + arr.getMax());
        /* long max = arr.removeMax();
        arr.display();
        System.out.println("Max after removing: " + arr.getMax());*/
        HighArray sortedArr = new HighArray(maxSize);
        while (arr.getMax() != -1) {
            long max = arr.removeMax();
            sortedArr.insert(max);
        }
        sortedArr.display();
    }
} // Конец класса HighArrayApp
