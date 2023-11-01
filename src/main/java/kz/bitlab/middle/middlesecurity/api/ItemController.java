package kz.bitlab.middle.middlesecurity.api;

import kz.bitlab.middle.middlesecurity.beans.SomeBean;
import kz.bitlab.middle.middlesecurity.dto.ItemDto;
import kz.bitlab.middle.middlesecurity.service.ItemService;
import kz.bitlab.middle.middlesecurity.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/item")
public class ItemController {

    private final ItemService itemService;
    private final SomeBean someBean;

    @GetMapping(value = "/item-list")
    public String itemList(){
        System.out.println(UserUtils.getCurrentUserName());
        return "This is itemList";
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('manager', 'admin')")
    public List<ItemDto> getItems(){
        return itemService.getItems();
    }

    @GetMapping(value = "/admin")
    @PreAuthorize("hasAnyRole('admin')")
    public String adminPage(){
        return "This is admin page";
    }
}
