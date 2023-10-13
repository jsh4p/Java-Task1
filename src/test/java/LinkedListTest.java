package test.java;

import main.java.jshap.LinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    //Проверка на добавление элемента в пустой список
    @Test
    void testPushBackInEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);


        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(1, list.at(0));
    }

    //Проверка на добавление элемента в заполненный список
    @Test
    void testPushBackInFilledList() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(637);

        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
        assertEquals(637, list.at(2));
    }

    //Проверка на получение элемента из заполненного списка
    @Test
    void testAtFromFilledList() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(637);

        assertEquals(2, list.at(1));
    }

    //Проверка на выпадение ошибки о нарушении границ списка при получении данных из списка
    @Test
    void testAtOutOfBoundsException() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(637);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.at(3);
        });
    }

    //Проверка на удаление первого элемента списка
    @Test
    void testRemoveFirstElementFromFilledList() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(637);

        int size = list.size();

        list.remove(0);

        assertEquals(2, list.at(0));
        assertEquals(size - 1, list.size());
    }

    //Проверка на удаление внутреннего элемента списка
    @Test
    void testRemoveInnerElementFromFilledList() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(637);

        int size = list.size();

        list.remove(1);

        assertEquals(637, list.at(1));
        assertEquals(size - 1, list.size());
    }

    //Проверка на удаление последнего элемента списка
    @Test
    void testRemoveLastElementFromFilledList() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(637);

        int size = list.size();

        list.remove(2);

        assertEquals(2, list.at(list.size() - 1));
        assertEquals(size - 1, list.size());
    }

    //Проверка на выпадение ошибки о нарушении границ списка при удалении данных из списка
    @Test
    void testRemoveOutOfBoundsException() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(637);

        list.remove(2);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(2);
        });
    }

    //Проверка пустого списка на пустоту
    @Test
    void testIsEmptyWithEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();

        assertTrue(list.isEmpty());
    }

    //Проверка заполненного списка на пустоту
    @Test
    void testIsEmptyWithFilledList() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(637);

        assertFalse(list.isEmpty());
    }

    //Проверка на получение корректного размера пустого списка
    @Test
    void testSizeFromEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();

        assertEquals(0, list.size());
    }

    //Проверка на получение корректного размера списка после добавления элемента
    @Test
    void testSizeAfterPushBack() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);
        list.pushBack(2);

        int size = list.size();

        list.pushBack(637);

        assertEquals(size + 1, list.size());
    }

    //Проверка на получение корректного размера списка после удаления элемента
    @Test
    void testSizeAfterRemove() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(637);

        int size = list.size();

        list.remove(1);

        assertEquals(size - 1, list.size());
    }

    //Проверка метода toString с пустым списком
    @Test
    void testToStringWithEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();

        assertEquals("[  ]", list.toString());
    }

    //Проверка метода toString с заполненным списком
    @Test
    void testToStringWithFilledList() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(637);

        assertEquals("[ 1 -> 2 -> 637 ]", list.toString());
    }

    @Test
    void testClearWithEmptyList() {
        LinkedList<Integer> list = new LinkedList<>();

        int size = list.size();

        list.clear();

        assertEquals(size, list.size());
    }

    @Test
    void testClearWithFilledList() {
        LinkedList<Integer> list = new LinkedList<>();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(637);

        int size = list.size();

        list.clear();

        assertEquals(size - 3, list.size());
    }
}