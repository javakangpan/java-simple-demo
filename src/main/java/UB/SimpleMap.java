package UB;

/**
 * 动态添加简单map key重复的
 * @date 2019/12/23
 */
public class SimpleMap<K, V> {
    private Object[][] pairs;
    private int index;

    public SimpleMap(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        int len = pairs.length;
        
        if(index < len) {
            pairs[index++] = new Object[] {key,value};
        }else if(index >= len) {
            int l = len + 1;
            Object[][] temp = new Object[l][0];
            for(int i = 0; i < len; i++) {
                temp[i] = pairs[i];
            }
            pairs = temp;
            put(key,value);
        }
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < pairs.length; i++) {
            if (key.equals(pairs[i][0])) {
                return (V)pairs[i][1];
            }
        }
        return null;
    }
    
    public int size() {
        return index;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(":");
            result.append(pairs[i][1].toString());
            if (i < index - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
}
