package leetcode.EncodeandDecodeStrings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ymyue on 12/9/15.
 */
public class TestCodec {
    @Test
    public void test0() {
        Codec codec = new Codec();
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list = codec.decode(codec.encode(list));
    }
}
