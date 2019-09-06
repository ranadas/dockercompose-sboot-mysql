package com.rdas.repository;

import com.rdas.entity.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//mvn clean test -Dspring.profiles.active=test -Dtest=ToDoRepositoryTest

@Ignore
@Log4j2
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class ToDoRepositoryTest {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private DataSource dataSource;

    @Test
    public void assertThatRepoInjected() throws Exception {
        log.info("\n\n\n---->>>" + dataSource.getConnection().getSchema() + "\n\n");
        assertNotNull(todoRepository);
    }

    @Test
    public void findAllToDosBeNotNullAndZero() {
        assertNotNull(todoRepository.findAll());
        assertEquals(todoRepository.findAll().size(), 0);
    }

    @Test
    public void testSaveToDoReturnsValueExpected() {
        Todo todo = Todo.builder().title("Add JaCoco to Codebase").completed(false).updatedDate(LocalDate.now()).build();

        todoRepository.save(todo);

        Todo todoFetched = todoRepository.findByTitle("Add JaCoco to Codebase");
        assertEquals(todoFetched.isCompleted(), false);
    }

    @Test
    public void deleteByIdTest() {
        Todo todo = Todo.builder().title("Add JaCoco to Codebase").completed(false).updatedDate(LocalDate.now()).build();
        todo = todoRepository.save(todo);

        todoRepository.deleteById(todo.getId());
    }
}