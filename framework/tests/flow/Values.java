import org.checkerframework.framework.testchecker.util.*;

import java.util.Collection;

public class Values {

    void test() {
        Object o = get();
        Object o1 = get1();
        Object o2 = get2();
        foo1(o1);
        foo2(o2);

        // :: error: (argument.type.incompatible)
        foo1(o);
        // :: error: (argument.type.incompatible)
        foo2(o1);
        // :: error: (argument.type.incompatible)
        foo1(o2);
        // :: error: (argument.type.incompatible)
        foo(o2);

        o1 = o2;
        foo2(o1);
        // :: error: (argument.type.incompatible)
        foo1(o1);

        o2 = get1();
        foo1(o2);
        // :: error: (argument.type.incompatible)
        foo2(o2);
    }

    void andlubTest(Collection<Object> c) {
        for (Object obj : c) {
            Object o = get1();
        }
    }

    void orlubTest(boolean b1, boolean b2) {
        if (b1) {
            Object o = get1();
            return;
        } else if (b2) {
            Object o = get2();
            return;
        }
    }

    void foo(@ValueTypeAnno Object o) {}

    void foo1(@ValueTypeAnno(1) Object o) {}

    void foo2(@ValueTypeAnno(2) Object o) {}

    @SuppressWarnings("flowtest:return.type.incompatible")
    @ValueTypeAnno
    Object get() {
        return null;
    }

    @SuppressWarnings("flowtest:return.type.incompatible")
    @ValueTypeAnno(1)
    Object get1() {
        return null;
    }

    @SuppressWarnings("flowtest:return.type.incompatible")
    @ValueTypeAnno(2)
    Object get2() {
        return null;
    }
}
