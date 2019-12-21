 package utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.FileSystems;

public interface IOUtil {
     
     /**
      * 获取当前工作目录
      * @return
      */
     public static String getCurrentWorkingDirectoryPath() {
         return FileSystems.getDefault().getPath("").toAbsolutePath().toString();
     }
     
     /**
      * 将异常堆栈跟踪转换为字符串。
      * @param throwable
      * @return
      */
     public static String stackTraceAsString(final Throwable throwable) {
         final StringWriter sw = new StringWriter();
         throwable.printStackTrace(new PrintWriter(sw));
         return sw.toString();
     }
}
