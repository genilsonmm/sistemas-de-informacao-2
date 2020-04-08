<template>
    <div class="container">
        <h1>Comentários</h1>
        <hr/>
        
        <!-- Formulário -->
        <FormToDo v-on:emit-comment="addComment" />

        <!-- Listagem de comentários -->

        <div v-for="(c, index) in comments" :key="index">
            <span>Autor: <strong>{{ c.name }}</strong></span>
            <p>{{ c.message }}</p>
            <div>
                <a v-on:click.prevent="removeComment(index)" href="#">Excluir</a>
            </div>
        </div>

      </div>
</template>

<script>

import FormToDo from './FormToDo.vue';

export default {
    name: "Comments",
    components:{
        FormToDo
    },
    data(){
        return{
           comments: [] 
        }
    },
    methods: {
        addComment(comment){
            this.comments.push(comment);
        },
        removeComment(index){
            //remover de index até 1
            this.comments.splice(index, 1);
        }
    }
}
</script>