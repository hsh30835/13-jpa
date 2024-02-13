package com.ohgiraffers.springjpa.menu.infra;

import com.ohgiraffers.springjpa.category.entity.Category;
import com.ohgiraffers.springjpa.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CategoryFindImpl implements CategoryFind{
    /*
    * 느슨한 결합관계를 사용했는데 이유는 강한 결합을 사용했을 때 다른쪽에서 변동 사항이 생겼을 시 남은 한쪽에서도
    * 모든 것을 수정해야 되서 유지보수 측면에서 안좋은데 느슨한 결합을 사용시 코드의 변경이 많이 없게 된다
    * */

    @Autowired
    CategoryService categoryService;
    // 카테고리에 의존성을 주입한 이유는 menu 앤티티에 categoryCode가 있기 때문인거같음
    @Override
    public Integer getCategory(int code) {
        return categoryService.findByCategory(code);
    }
}
