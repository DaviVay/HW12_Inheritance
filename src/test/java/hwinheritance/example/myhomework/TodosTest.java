package hwinheritance.example.myhomework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() { //тест для Todos - есть все задачи в порядке, в котором поместили
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskIfMatches() { //matches
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskIfNotMatches() { // нет совпадений
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicIfMatches() { //matches
        String[] subtasks = {"Стиральный порошок", "Шампунь"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Стиральный порошок");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicIfNotMatches() { // нет совпадений
        String[] subtasks = {"Стиральный порошок", "Шампунь"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Цветочный горшок");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingIfMatches() { //matches
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3-й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingIfNotMatches() { // нет совпадений
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3-й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        boolean actual = meeting.matches("Ответить подрядчику");
        Assertions.assertFalse(actual);
    }

    @Test
    public void whenFewTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void whenOneTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Хлеб");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void whenNoOneTaskFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить что-то");

        String[] subtasks = {"Молоко", "Пицца", "Мороженое"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Пирожное");
        Assertions.assertArrayEquals(expected, actual);
    }

}
