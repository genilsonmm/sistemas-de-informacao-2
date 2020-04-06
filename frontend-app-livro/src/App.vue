<template>
  <div class="container">
    
    <Topo/>

    <div class="row">
      <MenuLivros :livros="livros"></MenuLivros> 
      <Cadastro v-on:receiveBooksFromParent="addBook"></Cadastro>
    </div>

  </div>
</template>

<script>

import Topo from './components/Topo.vue';
import MenuLivros from './components/MenuLivros.vue';
import Cadastro from './components/Cadastro.vue';

export default {
  name: 'App',
  data(){
    return {
      livros: []
    }
  },
  components: {
    MenuLivros,
    Topo,
    Cadastro
  },
  methods: {
    addBook(book){
      this.livros.push(book);
    }
  }
}
</script>
