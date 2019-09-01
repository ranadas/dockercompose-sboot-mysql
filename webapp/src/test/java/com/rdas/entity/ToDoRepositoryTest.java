package com.rdas.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import java.util.Date;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ToDoRepositoryTest {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private DataSource dataSource;

    @Test
    public void assertThatRepoInjected() throws Exception {
        System.out.println("\n\n\n---->>>" + dataSource.getConnection().getSchema() + "\n\n");
        assertNotNull(todoRepository);
    }

    @Test
    public void findAllToDosBeNotNullAndZero() {
        assertNotNull(todoRepository.findAll());
        assertEquals(todoRepository.findAll().size(), 0);
    }

    @Test
    public void testSaveToDoReturnsValueExpected() {
        Todo todo = Todo.builder().title("Add JaCoco to Codebase").completed(false).updatedDate(new Date()).build();
        
        todoRepository.save(todo);
        //Get the ToDo now
        Optional<Todo> todoFetched = todoRepository.findById(1L);
        assertTrue(todoFetched.isPresent());

        assertEquals(todoFetched.get().isCompleted(), false);
        
    }


    
    public void deletByEmployeeIdTest() {
        Todo todo = Todo.builder().title("Add JaCoco to Codebase").completed(false).updatedDate(new Date()).build();    
        todo = todoRepository.save(todo);

        todoRepository.deleteById(todo.getId());
    }
}