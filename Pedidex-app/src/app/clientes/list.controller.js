export default class ListController {

    constructor(ClienteServico, Notification) {
        this.filter = ''
        this.records = []
        this._service = ClienteServico
        this.load()
    }

    load() {
        this._service.findAll()
          .then(data => {
              this.records = data
          })
          .catch(error => {
              console.log(error)
          })
    }

    excluir(id) {
        this._service.remove(id)
            .then(response => {
                this.load()
            }).catch(erro => {
            }) 
    }
}

ListController.$inject = ['ClienteServico', 'Notification']
