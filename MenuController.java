package com.example.demo.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/menus")
public class MenuController {


    private final MenuService menuService;


    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public List<Menu> getMenus(){

        return menuService.getMenus();
    }

    @PostMapping
    public void uploadNewMenu(@RequestBody Menu menu){
        menuService.addNewMenu(menu);
    }
    @DeleteMapping(path = "{menuId}")
    public void deleteMenu(
            @PathVariable("menuId") Long menuId){
        menuService.deleteMenu(menuId);
    }

    @PutMapping(path = "{menuId}")
    public void updateMenu(
            @PathVariable("menuId") Long menuId,
            @RequestParam(required = false) String info,
            @RequestParam(required = false) String type){
        menuService.updateMenu(menuId, info, type);
    }
}