import apiClient from '../services/configService.js'

export default {
    obterProfessores(){
        return apiClient.get('/professor')
    },
    novoProfessor(professor){
        return apiClient.post('/professor', professor)
    },
    editarProfessor(professor){
        return apiClient.put('/professor', professor)
    },
    deletar(id){
        return apiClient.delete('/professor/' + id)
    }
}
