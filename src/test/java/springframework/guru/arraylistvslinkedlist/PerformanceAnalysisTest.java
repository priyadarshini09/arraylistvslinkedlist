package springframework.guru.arraylistvslinkedlist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerformanceAnalysisTest {

    private List<String> testList;
    private InitializeContants initializeContants;
    private List<String> stringList;
    String find1;
    String find2;
    int max;

    @Before
    public void set() {
        initializeContants = new InitializeContants();
        String[] strings = initializeContants.strings;
        stringList = Arrays.asList(strings);
        max = initializeContants.MAX_ELEMENTS;
        find1 = initializeContants.getString(true, max/2 + 10);
        find2 = initializeContants.getString(true, max/2 +20);
    }

    @After
    public void tearDown() {
        initializeContants = null;
        stringList = null;
        find1 = null;
        find2 = null;
    }

    @Test
    public void addAll() {
        PerformanceAnalysis arrayListAddAll = new PerformanceAnalysis() {
            @Override
            String getName() {
                return "ArrayList add all";
            }

            @Override
            void setup() {
                testList = new ArrayList<>();
            }

            @Override
            void runMethod() { testList.addAll(stringList); }
        };
        arrayListAddAll.doPerformanceTest();

        PerformanceAnalysis linkedListAddAll = new PerformanceAnalysis() {
            @Override
            String getName() { return "LinkedList add all"; }

            @Override
            void setup() { testList = new ArrayList<>(); }

            @Override
            void runMethod() { testList.addAll(stringList); }
        };
        linkedListAddAll.doPerformanceTest();
    }

    @Test
    public void add() {
        PerformanceAnalysis arrayListAdd = new PerformanceAnalysis() {
            @Override
            String getName() { return "ArrayList add"; }

            @Override
            void setup() { testList = new ArrayList<>(); }

            @Override
            void runMethod() {
                for(String string : stringList) {
                    testList.add(string);
                }
            }
        };
        arrayListAdd.doPerformanceTest();

        PerformanceAnalysis linkedListAdd = new PerformanceAnalysis() {
            @Override
            String getName() { return "LinkedList add"; }

            @Override
            void setup() { testList = new ArrayList<>(); }

            @Override
            void runMethod() {
                for(String string : stringList) {
                    testList.add(string);
                }
            }
        };
        linkedListAdd.doPerformanceTest();
    }

    @Test
    public void findAndRemove() throws Exception {
        PerformanceAnalysis findAndRemoveInArrayList = new PerformanceAnalysis() {
            @Override
            String getName() {
                return "ArrayList find and remove";
            }

            @Override
            void setup() {
                testList = new ArrayList<>(max);
                testList.addAll(stringList);
            }

            @Override
            void runMethod() {
                List<String> removedList = testList;
                removedList.remove(find1);
                removedList.remove(find2);
            }
        };
        findAndRemoveInArrayList.doPerformanceTest();

        PerformanceAnalysis findAndRemoveInLinkedList = new PerformanceAnalysis() {
            @Override
            String getName() {
                return "LinkedList find and remove";
            }

            @Override
            void setup() {
                testList = new ArrayList<>(max);
                testList.addAll(stringList);
            }

            @Override
            void runMethod() {
                List<String> removedList = testList;
                removedList.remove(find1);
                removedList.remove(find2);
            }
        };
        findAndRemoveInLinkedList.doPerformanceTest();
    }

    @Test
    public void find() {
        PerformanceAnalysis findInArrayList = new PerformanceAnalysis() {
            @Override
            String getName() {
                return "ArrayList find";
            }

            @Override
            void setup() {
                testList = new ArrayList<>(max);
                testList.addAll(stringList);
            }

            @Override
            void runMethod() {
                List<String> findList = testList;
                findList.contains(find1);
                findList.contains(find2);
            }
        };
        findInArrayList.doPerformanceTest();

        PerformanceAnalysis findInLinkedList = new PerformanceAnalysis() {
            @Override
            String getName() {
                return "LinkedList find";
            }

            @Override
            void setup() {
                testList = new ArrayList<>(max);
                testList.addAll(stringList);
            }

            @Override
            void runMethod() {
                List<String> findList = testList;
                findList.contains(find1);
                findList.contains(find2);
            }
        };
        findInLinkedList.doPerformanceTest();
    }
}
