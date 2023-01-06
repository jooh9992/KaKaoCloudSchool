package com.kakao.school.service;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakao.school.domain.ItemEntity;
import com.kakao.school.dto.ItemDTO;
import com.kakao.school.persistence.ItemMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
	//@Autowired
	private final ItemMapper itemMapper;

	@Override
	public List<ItemDTO> allItem() {
		List<ItemDTO> list = new ArrayList<>();
		//Repository 메서드 호출
		List<ItemEntity> result = itemMapper.allItem();
		//결과 변환
		for(ItemEntity entity:result) {
			list.add(entityToDTO(entity));
		}
		return list;
	}

	@Override
	public ItemDTO getItem(int itemid) {
		ItemDTO dto = null;
		
		//데이터 가져오기
		ItemEntity entity = itemMapper.getItem(itemid);
		//null 여부 확인 후 변환
		if(entity != null) {
			dto = entityToDTO(entity);
		}
		
		return dto;
	}
}
