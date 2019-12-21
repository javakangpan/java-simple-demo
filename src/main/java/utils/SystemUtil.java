package utils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class SystemUtil {
    /**
     * 以小写字符串的形式获取操作系统的名称。
     * 
     * @return
     */
    public static String osName() {
        return System.getProperty("os.name").toLowerCase();
    }
    
    /**
     * 检查JVM是否为debug模式。
     * @return
     */
    public static boolean isDebuggerAttached() {
        final RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        return runtimeMXBean.getInputArguments()
                .stream()
                .anyMatch(arg -> arg.contains("-agentlib:jdwp"));

    }
}
