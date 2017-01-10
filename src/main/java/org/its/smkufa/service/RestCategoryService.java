package org.its.smkufa.service;

import java.util.List;

import javax.inject.Inject;

import org.its.smkufa.entity.Category;
import org.its.smkufa.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RestCategoryService implements CategoryService{

	@Inject
	private CategoryRepository categoryRepository;
	
	@Override
	public Category getCategoryById(long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}

	@Override
	public List<Category> findCategoryByName(String name) {
		// TODO Auto-generated method stub

		return categoryRepository.findByName(name);
	}

	@Override
	@Transactional
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		category.setId(0);
		
		return categoryRepository.save(category);
	}

	@Override
	@Transactional
	public Category updateCategory(long id, Category category) {
		// TODO Auto-generated method stub
		Category c = getCategoryById(category.getId());
		if (c != null) {
			c.setName(c.getName());
			c.setSubcategory(category.getSubcategory());
		}
		return c;
	}

	@Override
	@Transactional
	public void deleteCategory(long id) {
		// TODO Auto-generated method stub
		categoryRepository.delete(id);
		
	}
	
}
