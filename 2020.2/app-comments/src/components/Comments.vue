<template>
    <div>
        <h1>Comentários</h1>
        <div>
            <p>
                <input v-model="author" type="text" placeholder="Autor"/>
            </p>
            <p>
                <textarea v-model="message" placeholder="Comentário"></textarea>
            </p>
            <button v-on:click="addComemnt">Comentar</button>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Comments',
        data(){
            return {
                comments: [],
                author: '',
                message:''
            }
        },
        methods: {
            addComemnt(){
                if(this.message.trim() === ''){
                    return
                }

                let comment = {
                    author: this.author,
                    message: this.message
                }

                this.comments.push(comment);

                console.log(this.comments)
            }   
        }
    }
</script>

<style>

</style>