<template>
  <div id="app">
    <p id="title-text">App Comentários</p>
    <Comments />
  </div>
</template>

<script>

import Comments from './components/Comments.vue'

export default {
  name: 'App',
  components: {
    Comments
  }
}
</script>

<style>
  #app{
    font-family:Arial, Helvetica, sans-serif;
  }

  #title-text{
    text-align: center;
    font-size: 28px;
  }
</style>
