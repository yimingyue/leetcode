package LRU;

/**
 * Created with IntelliJ IDEA.
 * User: ymyue
 * Date: 11/29/13
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String [] argv) {
        LRUCache cache = new LRUCache(2);
        cache.set(2, 1);
        cache.set(2, 2);
        cache.get(2);
        cache.set(1, 1);
        cache.set(4, 1);
        cache.get(2);
//        cache.get(8);
//        cache.set(2, 1);
//        cache.get(5);
//        cache.set(7,1);
        cache.get(0);
    }
}
