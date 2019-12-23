 package UB;


/**
  * 动态添加的简单map 键不重复的
  * @date 2019/12/23
  */
 public class DynamicSimpleMap {
     
     private Object[][] fields;
     
     public DynamicSimpleMap(int initSize) {
         fields = new Object[initSize][2];
     }

     public <T> int hasKey(T key) {
         for(int i = 0; i < fields.length; i++) {
             if(key.equals(fields[i][0])) {
                 return i;
             }
         }
         return -1;
     }
     
     public <T, V> void put(T key,V value) {
         if(value != null) {
             int index = hasKey(key);
             if(-1 == index) {
                 index = setKey(key); 
             }
             fields[index][1] = value;
         }
     }
     
     private <T> int setKey(T key) {
         for(int i = 0; i < fields.length; i++) {
             if(null == fields[i][0]) {
                 fields[i][0] = key;
                 return i;
             }
         }
             
         Object[][] temp = new Object[fields.length + 1][2];
         for(int i = 0; i < fields.length; i++) {
             temp[i] = fields[i];
         }
         
         temp[fields.length] = new Object[] {null,null};
         fields = temp;
         return setKey(key);
     }
     
     public int size() {
         return fields.length;
     }
     
     public <T> Object get(T key) {
          return fields[hasKey(key)][1];
     }
     
     public String toString() {
         StringBuilder sb = new StringBuilder();
         for(Object[] obj : fields) {
             sb.append(obj[0]);
             sb.append(": " + obj[1]);
             sb.append("\n");
         }
         return new String(sb);
     }
}
