export default class FormController {

    constructor($stateParams, $state, PedidoServico, ClienteServico, Notification) {
        this.record = {}
        this.title = 'Adicionando registro'
        this._service = PedidoServico
        if ($stateParams.id) {
            this.title = 'Editando registro'
            this._service.findById($stateParams.id)
                .then(data => {
                    this.record = data
                    this.record.emissao = new Date(this.record.emissao)
                    //this.record.aprovacao = this.record.aprovacao ? new Date(this.record.aprovacao): ""
                })
        }
        this._state = $state
        this._notify = Notification

        this.clientes = []
        ClienteServico.findAll()
            .then(data => {
                this.clientes = data
            }, erro => {
                this._notify.error('Erro ao carregar os clientes!')
            })
        
    }

    save() {
        this._service.save(this.record)
            .then(resp => {
                this._notify.success('Registro salvo com sucesso!')
                this._state.go('pedido.list')
            }).catch(function(){
                this._notify.error('Erro ao salvar o registro!')
            })
    }
}

FormController.$inject = ['$stateParams', '$state', 'PedidoServico', 'ClienteServico', 'Notification']
