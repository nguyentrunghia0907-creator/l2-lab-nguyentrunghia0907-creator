package com.poly.lab5.service.impl;

import com.poly.lab5.data.DB;
import com.poly.lab5.entity.Item;
import com.poly.lab5.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        Item item = map.get(id);
        if(!map.containsKey(id)) {
            Item dbItem = DB.items.get(id);
            item = new Item(dbItem.getId(), dbItem.getName(), dbItem.getPrice(), 1);
            map.put(id, item);
        }else{
            item.setQty(item.getQty() + 1);
        }
        return null;
    }

    @Override
    public Item remove(Integer id) {
        return map.remove(id) ;
    }

    @Override
    public Item update(Integer id, int qty) {
        return null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public double getAmout() {
        return 0;
    }
}
