<template>
  <div>
    <ul>
      <li v-for="professor in professores" :key="professor.id">
        {{ professor.nome }}
      </li>
    </ul>

  <form v-on:submit="onSubmit">
    <input type="text" v-model="nome"/>
    <button>Cadastrar</button>
  </form>

  </div>
</template>

<script>

import professorService from '@/services/professorService.js'

export default {
  name: 'Home',
  data(){
    return {
      professores : [],
      nome : ""
    }
  },
  methods:{
    onSubmit(event){
        //Cadastrar um professor
        let professor = {
          nome : this.nome
        }

        professorService.novoProfessor(professor)
          .then(response => {
            //alert("Professor " + response.data.data.nome)
            this.professores.push(response.data.data)
          })
          .catch(error => {
            //alert(error.response)
          })
    }
  },
  created(){
    //Listar todos os professores
    professorService.obterProfessores()
      .then(response => {
        this.professores = response.data.data
      })
      .catch(error => {
        alert(error.response)
      })
  }
}
</script>
