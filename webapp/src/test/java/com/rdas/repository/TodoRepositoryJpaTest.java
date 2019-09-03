package com.rdas.repository;

import com.rdas.entity.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryJpaTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void whenFindByTitle_thenReturnTodo() {
        // given
        Todo alex = Todo.builder().title("Add Alex").completed(false).updatedDate(new Date()).build();
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Todo found = todoRepository.findByTitle(alex.getTitle());

        // then
        //assertThat(found.getTitle()).isEqualTo(alex.getTitle());
        assertEquals(found.isCompleted(), false);
    }
}