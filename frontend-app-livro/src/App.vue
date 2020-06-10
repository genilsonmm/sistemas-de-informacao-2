<template>
  <div class="container">
    
    <Topo/>

    <div class="row">
      <MenuLivros></MenuLivros> 
      <Cadastro></Cadastro>
    </div>

  </div>
</template>

<script>

import Topo from './components/Topo.vue';
import MenuLivros from './components/MenuLivros.vue';
import Cadastro from './components/Cadastro.vue';

export default {
  name: 'App',
  components: {
    MenuLivros,
    Topo,
    Cadastro
  },
  methods: {
  },
  mounted(){
  }
}
</script>
