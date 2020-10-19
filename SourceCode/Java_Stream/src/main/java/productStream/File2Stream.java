package productStream;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liujun
 * @version 1.0
 * @date 2020/9/9
 * @author—Email liujunfirst@outlook.com
 * @blogURL https://blog.csdn.net/ljfirst
 * @description File2Stream
 */
public class File2Stream {

    @Test
    public void file2stream() throws IOException {
        //String path = "./SourceCode/Java_Stream/src/main/java/productStream/data.txt";
        String path = "data.txt";
        Stream<String> lines =
                Files.lines(Paths.get(path), Charset.defaultCharset());
        List l = lines.collect(Collectors.toList());
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }
}
