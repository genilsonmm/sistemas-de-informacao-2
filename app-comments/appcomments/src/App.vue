<template>
  <div>
      <p>App Comentários</p>
      <Comments />
  </div>
</template>

<script>

import Comments from './components/Comments.vue';

export default {
  name: 'App',
  components: {
    Comments
  }
}
</script>

<style scoped>
  p{
    text-align: center;
  }
</style>