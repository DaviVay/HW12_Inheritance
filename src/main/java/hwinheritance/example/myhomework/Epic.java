package hwinheritance.example.myhomework;

import java.util.Arrays;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String[] subtasks() {
        return subtasks;
    }

    /*@Override
    public boolean matches(String query) {
        for (int i = 0; i < 3; i++) {
            if (Boolean.parseBoolean(Arrays.toString(subtasks))) {
                return true;
            }
            return false;
        }
        return false;
    }*/

    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
