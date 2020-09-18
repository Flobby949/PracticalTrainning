package Xingxin.Dao;

import Xingxin.Object.Key;

import java.util.List;

/**
 * @author Flobby
 */
public interface KeyDao {
    List<Key> getKey(Key key);

    int update(Key key);
}
