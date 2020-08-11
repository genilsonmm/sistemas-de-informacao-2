<template>
    <div class="col-md-8">
    <h3>Cadastro de livros</h3>
        <form v-on:submit="onSubmitForm">
            <div class="row">
            <div class="col-md-12 mb-3">
                <label for="title">Título</label>
                <input type="text" v-model="title" required class="form-control" id="title" placeholder="Título"/>
            </div>
            </div>
            <div class="row">
            <div class="col-md-6 mb-3">
                <label for="publishing">Editora</label>
                <input type="text" v-model="publishing" required class="form-control" id="publishing" placeholder="Editora"/>     
            </div>
            <div class="col-md-6 mb-3">
                <label for="page">Páginas</label>
                <input type="number" v-model="page" required class="form-control" id="page" placeholder="Páginas"/>
            </div>
            </div>

            <div class="row">
            <button class="btn btn-primary btn-block">Cadastrar</button>
            </div>
        </form>
        <hr>
    </div>
</template>

<script>
export default {
    name: "Cadastro",
    data(){
        return{
            title: '',
            publishing: '',
            page: ''
        }
    },
    methods: {
        onSubmitForm(event){
            console.log(this.title);
            this.$eventoLivro.$emit('receiveBooksFromParent', { title: this.title, publishing: this.publishing, page: this.page });

            this.title='';
            this.publishing='',
            this.page='';

            event.preventDefault();
        }
    },
    watch: {
        //Obter lista atualizada da base de dados
    }
}
</script>