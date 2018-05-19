package springframework.guru.arraylistvslinkedlist;

public class InitializeConstants {
    static final int MAX_ELEMENTS = 5;
    String[] strings = maxArray();

    private String[] maxArray() {
        String[] strings = new String[MAX_ELEMENTS];
        Boolean result = Boolean.TRUE;
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            strings[i] = getString(result, i);
            result = !result;
        }
        return strings;
    }

    protected String getString(Boolean result, int i) {
        return String.valueOf(result) + i + String.valueOf(!result);
    }
}
