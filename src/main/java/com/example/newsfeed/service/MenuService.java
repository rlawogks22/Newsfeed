package com.example.newsfeed.service;

import com.example.newsfeed.dto.CommonResponseDto;
import com.example.newsfeed.dto.MenuRequestDto;
import com.example.newsfeed.dto.MenuResponseDto;
import com.example.newsfeed.entity.Menu;
import com.example.newsfeed.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;
    MenuResponseDto menuResponseDto;
    private Menu menu;
    public MenuResponseDto post(MenuRequestDto menuRequestDto) {
        menu = new Menu(menuRequestDto);
        // 회원 인증 기능 추가
        menu = menuRepository.save(menu);
        return new MenuResponseDto(menu);
    }

    public List<MenuResponseDto> getAll() {
        List<Menu> menuList = menuRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        List<MenuResponseDto> menuResponseDtoList = new ArrayList<>();
        for (Menu m : menuList) {
            menuResponseDto = new MenuResponseDto(m);
            menuResponseDtoList.add(menuResponseDto);
        }
            return menuResponseDtoList;
    }

    @Transactional
    public MenuResponseDto updateMenu(MenuRequestDto menuRequestDto, Long menuId) {
        menu = getMenu(menuId);
        menu.updateMenu(menuRequestDto);
        menu.setModifiedAt(LocalDateTime.now());
        return new MenuResponseDto(menu);
    }

    @Transactional
    public void deleteMenu(Long menuId) {
        menu = getMenu(menuId);
        menuRepository.delete(menu);
    }


    public Menu getMenu(Long menuId) {
        return menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글 ID 입니다."));
    }

}

