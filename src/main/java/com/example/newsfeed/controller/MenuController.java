package com.example.newsfeed.controller;

import com.example.newsfeed.dto.CommonResponseDto;
import com.example.newsfeed.dto.MenuRequestDto;
import com.example.newsfeed.dto.MenuResponseDto;
import com.example.newsfeed.repository.MenuRepository;
import com.example.newsfeed.service.MenuService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/menus")
public class MenuController {
    private final MenuService menuService;

    @PostMapping
    public ResponseEntity<MenuResponseDto> post(@RequestBody MenuRequestDto menuRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(menuService.post(menuRequestDto));
    }
    @GetMapping
    public ResponseEntity<List<MenuResponseDto>> getAll(){
        List<MenuResponseDto> menuResponseDtoList = menuService.getAll();
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(menuResponseDtoList);
    }
    @GetMapping("/{menuId}")
    public void getMenu(@PathVariable Long menuId){

    }
    @PutMapping("/{menuId}")
    public MenuResponseDto updateMenu(@RequestBody MenuRequestDto menuRequestDto, @PathVariable Long menuId){
        return menuService.updateMenu(menuRequestDto, menuId);
    }
    @DeleteMapping("/{menuId}")
    public CommonResponseDto deleteMenu(@PathVariable Long menuId){
        menuService.deleteMenu(menuId);
        return new CommonResponseDto("게시글이 삭제되었습니다.", HttpStatus.OK.value());
    }
}
