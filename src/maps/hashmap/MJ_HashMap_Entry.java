package maps.hashmap;

import java.util.Objects;

/**
 *
 * @author Maisha Jauernig
 * @param <K>
 * @param <V>
 */
class MJ_HashMap_Entry <K, V> {
    private final K _key;
    private V _value;
    
    MJ_HashMap_Entry(K k, V v){
        _key = k;
        _value = v;
    }
    
    K getKey(){
        return _key;
    }
    
    V getValue(){
        return _value;
    }
    
    V setValue(V v){
        V old = _value;
        _value = v;
        return old;
    }
    
    @Override
    public int hashCode(){
        return _key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MJ_HashMap_Entry<?, ?> other = (MJ_HashMap_Entry<?, ?>) obj;
        return Objects.equals(this._key, other._key);
    }
}
