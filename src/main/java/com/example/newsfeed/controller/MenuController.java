package com.example.newsfeed.controller;

import com.example.newsfeed.dto.MenuRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @PostMapping
    public void post(@RequestBody MenuRequestDto menuRequestDto){

    }
    @GetMapping
    public void getAll(){

    }
    @GetMapping("/{menuId}")
    public void getMenu(@PathVariable Long menuId){

    }
    @PutMapping("/{menuId}")
    public void updateMenu(@PathVariable Long menuId){

    }
    @DeleteMapping("/{menuId}")
    public void deleteMenu(@PathVariable Long menuId){
    }
}
