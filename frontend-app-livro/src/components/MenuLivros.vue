<template>
  <div class="col-md-4 order-md-2 mb-4">
    <h4 class="d-flex justify-content-between align-items-center mb-3">Livros</h4>
    <ul class="list-group mb-3">
      <li class="list-group-item" v-for="livro in livros" :key="livro.id">{{ livro.title }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'MenuLivros',
  props :{
    livros: {
      type: Array,
      required: true
    }
  },
  methods: {
    addBook(book){
      this.livros.push(book);
    }
  }
}
</script>
