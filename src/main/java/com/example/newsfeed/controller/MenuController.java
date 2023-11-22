package com.example.newsfeed.controller;

import com.example.newsfeed.dto.CommonResponseDto;
import com.example.newsfeed.dto.MenuRequestDto;
import com.example.newsfeed.dto.MenuResponseDto;
import com.example.newsfeed.repository.MenuRepository;
import com.example.newsfeed.service.MenuService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.Message;
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
        List<MenuResponseDto> menuResponseDtoList = getMainPage();
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(menuResponseDtoList);
    }
    @GetMapping("/{menuId}")
    public void getMenu(@PathVariable Long menuId){

    }
    @PutMapping("/{menuId}")
    public ResponseEntity<MenuResponseDto> updateMenu(@RequestBody MenuRequestDto menuRequestDto, @PathVariable Long menuId){
        MenuResponseDto menuResponseDto =  menuService.updateMenu(menuRequestDto, menuId);
        return ResponseEntity.status(HttpStatus.OK.value()).body(menuResponseDto);
    }
    //삭제 후 메인페이지로 보내기 위해 getMainPage 메서드 사용
    @DeleteMapping("/{menuId}")
    public ResponseEntity<List<MenuResponseDto>> deleteMenu(@PathVariable Long menuId){
        menuService.deleteMenu(menuId);
        List<MenuResponseDto> menuResponseDtoList = getMainPage();
        return ResponseEntity.status(HttpStatus.OK.value()).body(menuResponseDtoList);
    }

    // 메인페이지로 보낼 dto 만들기
    private List<MenuResponseDto> getMainPage(){
        List<MenuResponseDto> menuResponseDtoList = menuService.getAll();
        return menuResponseDtoList;
    }

}
