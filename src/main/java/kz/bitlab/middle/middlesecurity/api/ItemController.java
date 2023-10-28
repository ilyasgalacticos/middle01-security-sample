package kz.bitlab.middle.middlesecurity.api;

import kz.bitlab.middle.middlesecurity.dto.ItemDto;
import kz.bitlab.middle.middlesecurity.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemDto> getItems(){
        return itemService.getItems();
    }
}
