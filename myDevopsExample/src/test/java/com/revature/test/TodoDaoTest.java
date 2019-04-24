package com.revature.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.revature.dao.TodoDao;
import com.revature.dao.TodoDaoImpl;

public class TodoDaoTest {

	private final TodoDao dao = new TodoDaoImpl();

	@Test
	public void getAllTodos_ShouldReturnOneRecord() {
		assertEquals(1, dao.getAllTodos().size());
	}
}
