package kz.bitlab.middle.middlesecurity.service;

import kz.bitlab.middle.middlesecurity.dto.ItemDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    public List<ItemDto> getItems(){
        List<ItemDto> itemDtoList = new ArrayList<>();
        itemDtoList.add(ItemDto.builder().id(1L).name("Iphone 15").price(700000).amount(20).build());
        itemDtoList.add(ItemDto.builder().id(2L).name("Iphone 14").price(600000).amount(25).build());
        itemDtoList.add(ItemDto.builder().id(3L).name("Iphone 13").price(500000).amount(20).build());
        itemDtoList.add(ItemDto.builder().id(4L).name("Iphone 12").price(400000).amount(15).build());
        itemDtoList.add(ItemDto.builder().id(5L).name("Iphone 11").price(300000).amount(10).build());
        itemDtoList.add(ItemDto.builder().id(6L).name("Iphone 10").price(200000).amount(8).build());
        itemDtoList.add(ItemDto.builder().id(7L).name("Iphone 8").price(100000).amount(5).build());
        return itemDtoList;
    }

}
