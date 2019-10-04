package maps.hashmap;

import HashSet.*;
import maps.IMJ_Map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Maisha Jauernig
 * @param <K>
 * @param <V>
 */
public class MJ_HashMap <K, V> implements IMJ_Map <K, V> {
    MJ_HashSet<MJ_HashMap_Entry<K, V>> _data;
    
    MJ_HashMap(){
        _data = new MJ_HashSet_Factory<MJ_HashMap_Entry<K, V>>().create();
    }
    
    private MJ_HashMap(MJ_HashSet<MJ_HashMap_Entry<K, V>> data){
        _data = data;
    }

    @Override
    public void clear() {
        _data = new MJ_HashSet_Factory<MJ_HashMap_Entry<K, V>>().create();
    }

    @Override
    public boolean containsKey(Object key) {
        return getValOfKey(key) != null;
    }
    
    @Override
    public V get(Object key){
        return getValOfKey(key);
    }

	@Override
	public IMJ_Map<K, V> getDeepCopy() {
		return new MJ_HashMap<K, V>(_data.getDeepCopy());
	}

	@Override
	public K getKey(int idx) {
		if (idx >= _data.size()) {
			return null;
		}
		return _data.get(idx).getKey();
	}
    
    @Override
    public boolean isEmpty(){
        return _data.isEmpty();
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V put(K key, V value) {
        V v = replace(key, value);
        if (v == null){
            MJ_HashMap_Entry<K, V> e = new MJ_HashMap_Entry<K, V>(key, value);
            _data.add(e);
            return null;
        }
        return v;
    }
    
    @Override
    public V remove(Object k){
        MJ_HashMap_Entry<K, V> e;
        V val;
        Iterator<MJ_HashMap_Entry<K, V>> iter = _data.iterator();
        while (iter.hasNext()){
            e = (MJ_HashMap_Entry<K, V>) iter.next();
            if (e.getKey() == k){
                val = (V) e.getValue();
                _data.remove(e);
                return val;
            }
        }
        return null;
    }

    @Override
    public V replace(K key, V val) {
        V v = getValOfKey(key);
        if (v != null){
            Iterator<MJ_HashMap_Entry<K, V>> iter = _data.iterator();
            while (iter.hasNext()){
                MJ_HashMap_Entry<K, V> entry = (MJ_HashMap_Entry<K, V>) iter.next();
                if (entry.getKey() == key){
                    entry.setValue(val);
                    return v;
                }
            }
        }
        return null;
    }
    
    @Override
    public int size(){
        return _data.size();
    }
    
    private V getValOfKey(Object key){
        MJ_HashMap_Entry<K, V> e;
        Iterator<MJ_HashMap_Entry<K, V>> iter = _data.iterator();
        
        while (iter.hasNext()){
            e = (MJ_HashMap_Entry<K, V>) iter.next();
            if (e.getKey() == key){
                return (V) e.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
