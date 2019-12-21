 package UB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;



public class OldSimpleLogger {
     /**
      * 日志文件名
      */
     private String logFileName;
     
     /**
      * 日志保存的路径
      * private String filePath;
      */
     
     
     /**
      * 日志文件大小
      * private int logCapacity;
      */
     
     /**
      * 日志格式
      */
     private String logSuffix = ".txt";
     
     /**
      * 日志记录时间
      */
     private String logTime;
     
     /**
      * 日志文件
      */
     private File file;
     
     
     /**
      * 日志信息
      */
     private StringBuilder sb;
     
     /**
      * 类
      */
     private static Class<?> cls;
     
     private OldSimpleLogger() {
         
     }
     
     private OldSimpleLogger(Class<?> cls) {
         this.logFileName = cls.getSimpleName();
         createLogFile(logFileName + logSuffix);
     }
     
     public static OldSimpleLogger getLogger(Class<?> classes) {
         cls = classes;
         return InnerLogger.logger;
     }
     
     private static final class InnerLogger {
         private final static OldSimpleLogger logger = new OldSimpleLogger(cls);
     }
     
     private File createLogFile(String fileName) {
         file = new File(fileName);
         if(!file.exists()) {
             try {
                 file.createNewFile();
             } catch (IOException e) {
                 return null;
             }
         }
         return file;
     }
     
     public void info(String logInfo) {
         sb = new StringBuilder();
         String time = getLogTime();
         sb.append(logInfo + "\u3000\u3000" + time + "\n");
         fileWriter();
     }
     
     private String getLogTime() {
         TimeZone timeZoneNY = TimeZone.getTimeZone("Asia/Shanghai");
         Date dates = new Date();
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINESE);
         dateFormat.setTimeZone(timeZoneNY) ;
         logTime = dateFormat.format(dates);
         return logTime;
     }
     
     /**
      * 写日志
      * 
      */
     private void fileWriter() {
         try {
             BufferedReader in = new BufferedReader(new StringReader(sb.toString()));
             PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
             String str;
             while((str = in.readLine()) != null) {
                 out.print(str + "\n");
             }
             out.close();
         } catch(IOException e) {
             return;
         }
     }
     
}
