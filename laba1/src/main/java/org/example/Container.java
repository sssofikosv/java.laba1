package org.example;

/**
 * Класс Container служит для хранения данных
 * @param <t> означает тип данных
 * @author Софья Свиридова
 */
public class Container<t> {
    protected t data = null;
    protected Container<t> next = null, point;

    /**
     * Функция addToList служит для вставки элемента в список
     * @param data данные типа t
     */
    public void addToList(t data) {
        if (data == null) return;
        if (this.data == null)
            this.data = data;
        else {
            point = this;
            while (point.next != null)
                point = point.next;
            point.next = new Container<>();
            point.next.data = data;
        }
    }

    /**
     * Функция getToHead - служебный метод, работает только внутри функции класса и служит для извлечения первого элемента из списка
     * @return значение самого первого эл-та
     */
    protected t getFromHead() {
        t data = this.data;
        if (this.next != null) {
            this.data = this.next.data;
            this.next = this.next.next;
        }
        else this.data = null;
        return data;
    }

    /**
     * Функция delElem служит для удаления элемента из списка
     * @param data данные типа t
     * @return возвращает true, если элемент успешно удалился, и false, если иначе
     */
    public boolean delELem(t data) {
        if (data == null) return false;
        boolean f = false;
        if (this.data == data) {
            f = true;
            getFromHead();
        }
        else {
            point = this;
            Container<t> prev = point;
            while (!f && point.next != null) {
                f = point.next.data == data;
                prev = point;
                point = point.next;
            }
            if (f) {
                prev.next = point.next;
                point = new Container<>();
                point = null;
            }
        }
        return f;
    }

    /**
     * Метод getData служит для извлечения последнего элемента из списка
     * @return возвращает данные последнего элемента
     */
    public t getData() {
        if (this.next == null)
            return getFromHead();
        else {
            point = this;
            while (point.next.next != null)
                point = point.next;
            t data = point.next.data;
            point.next = new Container<>();
            point.next = null;
            return data;
        }
    }

    /**
     * Функция output служит для вывода элементов списка на экран
     */
    public void output() {
        point = this;
        for (int i = 0; point != null; i++) {
            if (point.data != null)
                System.out.println(point.data);
            point = point.next;
        }
    }
}

