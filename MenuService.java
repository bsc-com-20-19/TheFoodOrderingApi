package com.example.demo.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    //    @Autowired
//    private MenuItemRepository pam;
//    private Menu MenuList;
    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }

    public void addNewMenu(Menu menu){

        menuRepository.save(menu);
    }
    public void deleteMenu(Long menuId){
        boolean exists = menuRepository.existsById(menuId);
        if (!exists) {
            throw new IllegalStateException(
                    "Menu with id " + menuId + " does not exists");
        }
        menuRepository.deleteById(menuId);
    }

    @Transactional
    public void updateMenu(Long menuId,
                           String info,
                           String type) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalStateException(
                        "Menu with menuId " + menuId + " does not exist"));
        menu.setInfo(info);
        menu.setType(type);
    }
}