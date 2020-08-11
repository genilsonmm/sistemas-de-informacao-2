<template>
    <div class="form-group">
        <p>
            <input v-model="name" type="text" placeholder="Autor" class="form-control">
        </p>
        <p>
            <textarea v-model="message" placeholder="Comentários" class="form-control"></textarea>
        </p>
        <button v-on:click="addComment" class="btn btn-primary">Comentar</button>
    </div>
</template>

<script>
export default {
    name: "FormToDo",
    data(){
        return{
            name: '',
            message: ''
        }
    },
    methods :{
        addComment(){
            if(this.message.trim() === ''){
                return;
            }

            //Enviar os dados para o componente pai
            this.$emit("emit-comment", {name: this.name, message: this.message});

            
            this.message = 'asdasdasdasds';

            let livros = {
                titulo: "livro teste"
            }

            this.name = livros.titulo;

        }
    }
}
</script>