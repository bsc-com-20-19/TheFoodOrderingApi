package com.example.demo.menu;


import javax.persistence.*;
@Entity
@Table
public class Menu {
    @Id
    @SequenceGenerator(
            name = "menu_sequence",
            sequenceName = "menu_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menu_sequence"
    )

    private Long menuId;
    private String info;
    private String type;

    public Menu() {
    }

    public Menu(Long menuId, String type, String info){
        this.menuId = menuId;
        this.type = type;
        this.info = info;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + menuId +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}