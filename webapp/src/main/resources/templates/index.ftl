<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Freemaker UI">
    <meta name="author" content="Rana Das">    
    <title>Docker Compose with Spring Boot, MySQL, NGINX</title>
    <link href="/css/main.css" rel="stylesheet" />
    <#--  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>       -->
</head>
<body>

<section class="todoapp">
    <header class="header">
        <h1>todos</h1>
        <input class="new-todo"
               autofocus autocomplete="off"
               placeholder="What needs to be done?"
               v-model="newTodo"
               @keyup.enter="addTodo">
    </header>
    <section class="main" v-show="todos.length" v-cloak>
        <input class="toggle-all" type="checkbox" v-model="allDone">
        <ul class="todo-list">
            <li v-for="todo in filteredTodos"
                class="todo"
                :key="todo.id"
                :class="{ completed: todo.completed, editing: todo == editedTodo }">
                <div class="view">
                    <input class="toggle" type="checkbox" v-model="todo.completed">
                    <label @dblclick="editTodo(todo)">{{ todo.title }}</label>
                    <button class="destroy" @click="removeTodo(todo)"></button>
                </div>
                <input class="edit" type="text"
                       v-model="todo.title"
                       v-todo-focus="todo == editedTodo"
                       @blur="doneEdit(todo)"
                       @keyup.enter="doneEdit(todo)"
                       @keyup.esc="cancelEdit(todo)">
            </li>
        </ul>
    </section>
    <footer class="footer" v-show="todos.length" v-cloak>
    <span class="todo-count">
      <strong>{{ remaining }}</strong> {{ remaining | pluralize }} left
    </span>
        <ul class="filters">
            <li><a href="#/all" :class="{ selected: visibility == 'all' }">All</a></li>
            <li><a href="#/active" :class="{ selected: visibility == 'active' }">Active</a></li>
            <li><a href="#/completed" :class="{ selected: visibility == 'completed' }">Completed</a></li>
        </ul>
        <button class="clear-completed" @click="removeCompleted" v-show="todos.length > remaining">
            Clear completed
        </button>
    </footer>
</section>
<footer class="info">
    <p>Double-click to edit a todo</p>
</footer>

<script src="https://unpkg.com/vue@2.5.8/dist/vue.js"></script>
<script src="https://unpkg.com/axios@0.17.1/dist/axios.min.js"></script>
<script src="/js/main.js"></script>

</body>
</html>