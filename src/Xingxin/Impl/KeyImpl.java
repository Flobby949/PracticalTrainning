package Xingxin.Impl;

import Xingxin.util.DBUtils;
import Xingxin.Dao.KeyDao;
import Xingxin.Object.Key;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Flobby
 * @version :1.0
 * @date :2020/6/21
 * @ClassName :
 */

public class KeyImpl implements KeyDao {

    @Override
    public List<Key> getKey(Key key) {
        String sql="select * from keyword where id=? and sdkey=?";
        List<Key> keyList=new ArrayList<>();
        List<Map<String, Object>> maplist= DBUtils.query(sql,key.getId(),key.getKey());
        for(Map<String, Object> map:maplist){
            Key ne=new Key();
            ne.setKey((String) (map.get("sdkey")));
            keyList.add(ne);
        }
        return keyList;
    }

    @Override
    public int update(Key key) {
        int code = 0;
        String sql = "update keyword set sdkey = ? where id = ?";
        code = DBUtils.update(sql,key.getKey(),key.getId());
        return code;
    }
}
