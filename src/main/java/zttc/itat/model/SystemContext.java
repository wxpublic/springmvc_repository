package zttc.itat.model;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2018-12-09 下午 7:28
 */
public class SystemContext {
    private static ThreadLocal<Integer> offset = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> size = new ThreadLocal<Integer>();

    public static Integer getOffset() {
        return offset.get();
    }

    public static void setOffset(Integer _offset) {
        offset.set(_offset);
    }

    public static void removeOffset(){
        offset.remove();
    }

    public static Integer getSize() {
        return size.get();
    }

    public static void setSize(Integer _size) {
        size.set(_size);
    }

    public static void removeSize(){
        size.remove();
    }
}
