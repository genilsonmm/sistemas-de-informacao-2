<template>
  <div class="col-md-4 order-md-2 mb-4">
    <h4 class="d-flex justify-content-between align-items-center mb-3">Livros</h4>
    <ul class="list-group mb-3">
      <li class="list-group-item" v-for="livro in livros" :key="livro.id">
        <div><strong>{{ livro.title }}</strong></div>
        <div>{{ livro.publishing }}  <span class="ml-2">Páginas {{ livro.page }} </span> </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data(){
    return {
      livros : []
    }
  },
  name: 'MenuLivros',
  mounted(){
    this.$eventoLivro.$on('receiveBooksFromParent', (novoLivro) => {
      if(novoLivro){
        this.livros.push(novoLivro)
      }
    })
  }
}
</script>
